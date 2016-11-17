module \test::SigScoresTester

import SigScores;
import TestHelpers;

// Check star rating for VolumeScore
test bool TestVolumePlusPlus() = ExpectEqualInt(4, VolumeScore(66000));
test bool TestVolumePlus() = ExpectEqualInt(3, VolumeScore(246000));
test bool TestVolumeNeutral() = ExpectEqualInt(2, VolumeScore(655000));
test bool TestVolumeMinus() = ExpectEqualInt(1, VolumeScore(1310000));
test bool TestVolumeMinusMinus() = ExpectEqualInt(0, VolumeScore(1310001));

// Complexity is a two-step rocket
// Get the first step right
test bool TestVeryHigh() = ExpectEqualInt(3, ComplexityIndex(10));
test bool TestHigh() = ExpectEqualInt(2, ComplexityIndex(20));
test bool TestMedium() = ExpectEqualInt(1, ComplexityIndex(50));
test bool TestLow() = ExpectEqualInt(0, ComplexityIndex(51));

// Using the complexity score, we can create the amounts

// Sample Distributions for Percentages
list[int] DistributionPlusPlus = [74, 24, 0, 0] ;  
list[int] DistributionPlus = [67, 29, 4, 0] ;  
list[int] DistributionNeutral = [52, 39, 9, 0] ;  
list[int] DistributionMinus = [33, 49, 14, 4] ;
list[int] DistributionMinusMinus = [32,49,14,5];

test bool TestDistributionPlusPlus() = ExpectEqualInt(4, ComplexityScore(DistributionPlusPlus));
test bool TestDistributionPlus() = ExpectEqualInt(3, ComplexityScore(DistributionPlus));
test bool TestDistributionNeutral() =ExpectEqualInt(2, ComplexityScore(DistributionNeutral));
test bool TestDistributionMinus() = ExpectEqualInt(1, ComplexityScore(DistributionMinus));
test bool TestDistributionMinusMinus() =ExpectEqualInt(0, ComplexityScore(DistributionMinusMinus));
