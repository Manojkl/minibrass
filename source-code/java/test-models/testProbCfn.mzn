var 0.0 .. 5.0: s1;
var 0.0 .. 5.0: s2; 

include "testProbCfn_o.mzn";
%include "soft_constraints/pvs_gen_search.mzn"; % for minibrass-search style using the generated predicate

function var float: leqErr(var float:a, var float: b) =
  max(a-b, 0.0);

function var -10.0 .. 8.0: geqErr(var 0.0 .. 10.0 :a, var 0.0 .. 8.0: b) =
  max(b-a, 0.0);
  
solve
%:: float_search([s1,s2], input_order, indomain_max, complete)
satisfy;

output ["s1 = \(s1); s2 = \(s2)"] ++ [ "\nValuations: topLevelObjective = \(topLevelObjective)\n"];

