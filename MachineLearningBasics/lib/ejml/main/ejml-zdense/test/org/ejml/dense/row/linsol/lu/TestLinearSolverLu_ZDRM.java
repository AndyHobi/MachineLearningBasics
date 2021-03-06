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

package org.ejml.dense.row.linsol.lu;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.lu.LUDecompositionAlt_ZDRM;
import org.ejml.dense.row.linsol.GenericLinearSolverChecks_ZDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;


/**
 * @author Peter Abeles
 */
public class TestLinearSolverLu_ZDRM extends GenericLinearSolverChecks_ZDRM {

    public TestLinearSolverLu_ZDRM() {
        shouldWorkRectangle = false;
        shouldFailSingular = false;
    }

    @Override
    protected LinearSolverDense<ZMatrixRMaj> createSolver(ZMatrixRMaj A ) {
        LUDecompositionAlt_ZDRM decomp = new LUDecompositionAlt_ZDRM();

        return new LinearSolverLu_ZDRM(decomp);
    }
}
