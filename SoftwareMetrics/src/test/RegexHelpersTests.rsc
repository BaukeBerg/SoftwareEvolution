module \test::RegexHelpersTests

import \helpers::TestHelpers;
import \helpers::RegexHelpers;
import String;

test bool AssumeRegexTrue() = ExpectTrue(rexpMatch("String 88 ", RegexForInts));
test bool AssumeRegexWithColon() = ExpectTrue(rexpMatch("String 88;", RegexForInts));
test bool AssumeRegexWithEqual() = ExpectTrue(rexpMatch("String=88;", RegexForInts));
test bool AssumeRegexNoLeadingSpace() = ExpectFalse(rexpMatch("String88 ", RegexForInts));
test bool AssumeRegexNoTralingSpace() = ExpectFalse(rexpMatch("String 88", RegexForInts));
 