module \test::ListHelperTests

import \helpers::ListHelpers;
import \helpers::TestHelpers;


list[int] SampleCollection = [1,2,3,4,6];

test bool CheckValid() = true == Contains(SampleCollection, 3);
test bool CheckLowBound() = false == Contains(SampleCollection, 0);
test bool CheckTopBound() = false == Contains(SampleCollection, 7);
test bool CheckCenterItem() = false == Contains(SampleCollection, 5);

test bool CheckListPrint() = ExpectEqual("[1,2,3,4,6]", EncodeListContents(SampleCollection));

list[tuple[int, list[int]]] SampleClones = [
                                              < 1, [1,2,3] >,
                                              < 3, [4,6,5] >
                                           ];
                                           
test bool CheckClonesPrint() = ExpectEqual("\<1,[1,2,3]\>\n\<3,[4,6,5]\>\n", StoreClones(SampleClones));