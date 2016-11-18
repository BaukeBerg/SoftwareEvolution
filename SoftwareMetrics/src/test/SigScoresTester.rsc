module \test::SigScoresTester

import SigScores;
import TestHelpers;

// Check star rating for VolumeScore
test bool TestVolumePlusPlus() = ExpectEqual(4, VolumeScore(66000));
test bool TestVolumePlus() = ExpectEqual(3, VolumeScore(246000));
test bool TestVolumeNeutral() = ExpectEqual(2, VolumeScore(655000));
test bool TestVolumeMinus() = ExpectEqual(1, VolumeScore(1310000));
test bool TestVolumeMinusMinus() = ExpectEqual(0, VolumeScore(1310001));

// Complexity is a two-step rocket
// Get the first step right
test bool TestVeryHigh() = ExpectEqual(3, UnitComplexityIndex(10));
test bool TestHigh() = ExpectEqual(2, UnitComplexityIndex(20));
test bool TestMedium() = ExpectEqual(1, UnitComplexityIndex(50));
test bool TestLow() = ExpectEqual(0, UnitComplexityIndex(51));

// Using the complexity score, we can create the amounts

// Sample Distributions for Percentages
list[int] DistributionPlusPlus = [74, 24, 0, 0] ;  
list[int] DistributionPlus = [67, 29, 4, 0] ;  
list[int] DistributionNeutral = [52, 39, 9, 0] ;  
list[int] DistributionMinus = [33, 49, 14, 4] ;
list[int] DistributionMinusMinus = [32,49,14,5];

test bool TestDistributionPlusPlus() = ExpectEqual(4, UnitComplexityScore(DistributionPlusPlus));
test bool TestDistributionPlus() = ExpectEqual(3, UnitComplexityScore(DistributionPlus));
test bool TestDistributionNeutral() =ExpectEqual(2, UnitComplexityScore(DistributionNeutral));
test bool TestDistributionMinus() = ExpectEqual(1, UnitComplexityScore(DistributionMinus));
test bool TestDistributionMinusMinus() =ExpectEqual(0, UnitComplexityScore(DistributionMinusMinus));
