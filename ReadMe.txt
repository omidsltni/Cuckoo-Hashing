In this code We tried to show you how cuckoo hashing works by using 2 hash tabeles T1 & T2 with size of N,and we index each key with tow hash fuctions H1 & H2.
Main Oprations:
-Search:
	The element of x can exist in one of this two places in T1 at H1(x) or in T2 at H2(x)
-Delete:
	We search for the element and if it exist then we delete it.
-Insert:
	We put the x in T1[H1(x)], however if T1[H1(x)] were already full with value of y we put y in T2[H2(y)] and if it was occupied by z,
	we put z at T1[H1(z)] we continue this till we find an empty place.
you can see an example of cuckoo hashing in this code by considering
	N = 11
	H1(x) = k % 11
	H2(x) = (floor(k / 11) % 11)
