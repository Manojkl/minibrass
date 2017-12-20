package isse.mbr.MiniBrassWeb.shared.model.voting;

import isse.mbr.MiniBrassWeb.shared.parsing.MiniBrassParseException;

/**
 * A factory providing different instantiations of voting procedures
 * can be used for reflection in the future 
 * @author Alexander Schiendorfer
 *
 */
public class VotingFactory {
	public static VotingProcedure getVotingProcedure(String keyword) throws MiniBrassParseException {
		switch(keyword) {
		case "condorcet":
			return new CondorcetVoting();
		case "majorityTops":
			return new MajorityTopsVoting();
		case "approval":
			return new ApprovalVoting();
		case "sum":	
			return new SumVoting();
		case "sumMin":	
			return new SumVoting(false);
		case "sumMax":	
			return new SumVoting(true);
		default:
				throw new MiniBrassParseException("Voting procedure ["+keyword+"] unknown.");
		}
	
			
	}
}