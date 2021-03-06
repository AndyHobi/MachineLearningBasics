/*
 * Copyright (c) 2009-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ejml.dense.row.decompose.chol;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_CDRM;
import org.ejml.dense.row.RandomMatrices_CDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * @author Peter Abeles
 */
public class TestCholeskyDecompositionCommon_CDRM {
    Random rand = new Random(234);

    int N = 6;

    /**
     * The correctness of getT(null) has been tested else where effectively.  This
     * checks to see if it handles the case where an input is provided correctly.
     */
    @Test
    public void getT() {
        CMatrixRMaj A = RandomMatrices_CDRM.hermitianPosDef(N, rand);

        CholeskyDecomposition_F32<CMatrixRMaj> cholesky = new Dummy(true);

        CMatrixRMaj L_null = cholesky.getT(null);
        CMatrixRMaj L_provided = RandomMatrices_CDRM.rectangle(N, N, rand);
        assertTrue( L_provided == cholesky.getT(L_provided));

        assertTrue(MatrixFeatures_CDRM.isEquals(L_null, L_provided));
    }

    private class Dummy extends CholeskyDecompositionCommon_CDRM {

        public Dummy(boolean lower) {
            super(lower);
            T = RandomMatrices_CDRM.rectangle(N,N,rand);
            n = N;
        }

        @Override
        protected boolean decomposeLower() {
            return true;
        }

        @Override
        protected boolean decomposeUpper() {
            return true;
        }
    }
}