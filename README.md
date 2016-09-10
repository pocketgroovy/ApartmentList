I have created 2 versions for this solution.

First version is my favorite but it didn't give you the same result you specified in the email.
My take of snippets for this case were sentences including any of the query keyword.
1st version will find those sentences and returns them even if they are not side by side in the original description.
I igonored any sentence between them.
The reason I did this way was that the original descriptions to me was more like bulletpoints description instead of paragraph.
I didn't see the tight connection between the sentences next to each other.

Second version will give you the exact same result in your email.
It tries to find the first occurrence of any of the keywords in a sentence, then second occurrence of any of the keywords in a sentence.
Return all the senteces between them
However, this solution has some issues.
First of all, the result snippets could be the entire descriptions if the first sentence has any of the keyword and if any of keyword found next were in last sentence.
Another issue is thay if there are multiple sentences using the keywords, we need to have additional information or keywords to prioritize among the sentences. Currently it will return sentences between a sentence which contains the keyword found first and sentence which contains the keyword found next.

None of my functions are handling to find part of the keyword in the sentences.

I have included the unit test files