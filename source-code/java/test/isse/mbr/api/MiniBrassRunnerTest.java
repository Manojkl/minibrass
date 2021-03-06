package isse.mbr.api;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import isse.mbr.tools.execution.MiniZincConfiguration;
import isse.mbr.tools.execution.MiniZincResult;
import isse.mbr.tools.execution.MiniZincSolution;
import isse.mbr.tools.execution.MiniZincVariable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import isse.mbr.parsing.MiniBrassParseException;
import isse.mbr.tools.execution.MiniBrassRunner;

public class MiniBrassRunnerTest {

	private MiniBrassRunner minibrassRunner;
	private File constraintModelFile;
	private File constraintModelFileForPareto;
	private File constraintModelFileForLex;
	
	private File preferenceModelFile;
	private File preferenceModelFileLex;
	private File preferenceModelFilePareto;
	
	@Before
	public void setup () {
		MiniZincConfiguration configuration = new MiniZincConfiguration();
		configuration.setSolverId("Gecode");
		configuration.setUseAllSolutions(false);
		minibrassRunner = new MiniBrassRunner();
		minibrassRunner.setDebug(false);
		minibrassRunner.setMiniZincConfiguration(configuration);
		
		String constraintModel = "test-models/classicNoSearch.mzn";
		constraintModelFile = new File(constraintModel);
		constraintModelFileForPareto = new File("test-models/new-api/classicNoSearchPareto.mzn");
		constraintModelFileForLex = new File("test-models/new-api/classicNoSearchLex.mzn");
		
		String preferenceModel = "test-models/classicNoSearch.mbr";
		preferenceModelFile = new File(preferenceModel);
		preferenceModelFileLex = new File("test-models/new-api/classicNoSearchLex.mbr");
		preferenceModelFilePareto = new File("test-models/new-api/classicNoSearchPareto.mbr");
		
	}
	
	@Test
	public void testBasic() throws IOException, MiniBrassParseException {
		MiniZincSolution solution = minibrassRunner.executeBranchAndBound(constraintModelFile, preferenceModelFile, Collections.emptyList());
	}
	
	@Test
	public void testPareto() throws IOException, MiniBrassParseException {
		minibrassRunner.executeBranchAndBound(constraintModelFileForPareto, preferenceModelFilePareto, Collections.emptyList());
	}

	@Test
	public void testLex() throws IOException, MiniBrassParseException {
		minibrassRunner.executeBranchAndBound(constraintModelFileForLex, preferenceModelFileLex, Collections.emptyList());
	}
	
	
	@Test
	public void testDebug() throws IOException, MiniBrassParseException {
		String model = "test-models/debug/testModel.mzn";
		File modelFile = new File(model);
		File dataFile = new File("test-models/debug/testModel.dzn");
		File preferenceFile = new File("test-models/debug/preferenceDay_0.mbr");
		MiniZincConfiguration configuration = new MiniZincConfiguration();
		configuration.setSolverId("OSICBC");
		configuration.setUseAllSolutions(false);
		minibrassRunner.setDebug(true);
		minibrassRunner.setMiniZincConfiguration(configuration);
		minibrassRunner.executeBranchAndBound(modelFile, preferenceFile, Arrays.asList(dataFile));
	}
	
}
