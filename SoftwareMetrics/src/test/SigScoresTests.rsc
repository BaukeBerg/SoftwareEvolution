module \test::SigScoresTests

import \metrics::SigScores;
import \helpers::TestHelpers;

// Check star rating for VolumeScore
test bool TestVolumePlusPlus() = ExpectEqual(0, VolumeScore(66000));
test bool TestVolumePlus() = ExpectEqual(1, VolumeScore(246000));
test bool TestVolumeNeutral() = ExpectEqual(2, VolumeScore(655000));
test bool TestVolumeMinus() = ExpectEqual(3, VolumeScore(1310000));
test bool TestVolumeMinusMinus() = ExpectEqual(4, VolumeScore(1310001));

// Complexity is a two-step rocket
// Get the first step right
test bool TestVeryHigh() = ExpectEqual(0, UnitComplexityIndex(10));
test bool TestHigh() = ExpectEqual(1, UnitComplexityIndex(20));
test bool TestMedium() = ExpectEqual(2, UnitComplexityIndex(50));
test bool TestLow() = ExpectEqual(3, UnitComplexityIndex(51));

// Using the complexity score, we can create the amounts

// Sample Distributions for Percentages
list[int] DistributionPlusPlus = [74, 24, 0, 0] ;  
list[int] DistributionPlus = [67, 29, 4, 0] ;  
list[int] DistributionNeutral = [52, 39, 9, 0] ;  
list[int] DistributionMinus = [33, 49, 14, 4] ;
list[int] DistributionMinusMinus = [32,49,14,5];

test bool TestDistributionPlusPlus() = ExpectEqual(0, UnitComplexityScore(DistributionPlusPlus));
test bool TestDistributionPlus() = ExpectEqual(1, UnitComplexityScore(DistributionPlus));
test bool TestDistributionNeutral() =ExpectEqual(2, UnitComplexityScore(DistributionNeutral));
test bool TestDistributionMinus() = ExpectEqual(3, UnitComplexityScore(DistributionMinus));
test bool TestDistributionMinusMinus() =ExpectEqual(4, UnitComplexityScore(DistributionMinusMinus));

test bool TestSigRatingPlusPlus() = ExpectEqual("★★★★★", StarRating(0));
test bool TestSigRatingPlus() = ExpectEqual("★★★★☆", StarRating(1));
test bool TestSigRatingNeutral() = ExpectEqual("★★★☆☆", StarRating(2));
test bool TestSigRatingMinus() = ExpectEqual("★★☆☆☆", StarRating(3));
test bool TestSigRatingMinusMinus() = ExpectEqual("★☆☆☆☆", StarRating(4));