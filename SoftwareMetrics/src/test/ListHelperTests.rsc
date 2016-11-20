module \test::ListHelperTests

import \helpers::ListHelpers;
import \helpers::TestHelpers;


list[int] SampleCollection = [1,2,3,4,6];

test bool CheckValid() = true == Contains(SampleCollection, 3);
test bool CheckLowBound() = false == Contains(SampleCollection, 0);
test bool CheckTopBound() = false == Contains(SampleCollection, 7);
test bool CheckCenterItem() = false == Contains(SampleCollection, 5);

test bool CheckListPrint() = ExpectEqual("[1,2,3,4,6]", EncodeListContents(SampleCollection));
test bool CheckEmptyListPrint() = ExpectEqual("[]", EncodeListContents([]));

test bool CheckBackAndForth() = ExpectEqual(SampleCollection, DecodeListContents(EncodeListContents(SampleCollection)));

list[tuple[int, list[int]]] SampleClones = [
                                              < 1, [1,2,3] >,
                                              < 3, [4,6,5] >
                                           ];
                                           
test bool CheckClonesPrint() = ExpectEqual("1$[1,2,3]\r\n3$[4,6,5]\r\n", StoreClones(SampleClones));
test bool CheckClonesBackAndForth() = ExpectEqual(SampleClones, LoadClones(StoreClones(SampleClones)));

test bool CheckListTrimming() = ExpectEqual(["Hello", "Goodbye"], TrimList(["    \r\n   \t Hello", "Goodbye \n\r\t   "]));
test bool CheckListTrimmingRemoveEmptyLines() = ExpectEqual(["Hello", "Goodbye"], TrimList(["    \r\n   \t Hello", "              ", "Goodbye \n\r\t   "]));
