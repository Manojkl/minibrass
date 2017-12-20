package isse.mbr.MiniBrassWeb.shared.model.types;

import isse.mbr.MiniBrassWeb.shared.model.parsetree.AbstractPVSInstance;

/**
 * MiniZinc types than can be used as parameters
 * Intended as a purely virtual interface - each type
 * shall either be
 * 
 * - all var types (MiniZincVarType)
 * - arrays of var types, multisets (MiniZincArrayLike)
 * @author Alexander Schiendorfer
 *
 */
public interface MiniZincParType {
	String toMzn(AbstractPVSInstance instance);
}
