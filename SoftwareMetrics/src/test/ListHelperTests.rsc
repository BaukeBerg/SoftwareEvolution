module \test::ListHelperTests

import \helpers::ListHelpers;

list[int] SampleCollection = [1,2,3,4,6];

test bool CheckValid() = true == Contains(SampleCollection, 3);
test bool CheckINValid() = false == Contains(SampleCollection, 0);
test bool CheckINValid() = false == Contains(SampleCollection, 7);
test bool CheckINValid() = false == Contains(SampleCollection, 5);