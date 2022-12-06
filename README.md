# Lab 5: Hashing and Collisions

<p>A hash function is composed of two parts: a hash code and a compression function. The purpose of the assignment is to perform a comparative analysis of several hash functions. 


<p>In the first part, the hash code is investigated using a polynomial hash code. Let a word with k characters be written as x<sub>0</sub> x<sub>1</sub> ... x<sub>k-1</sub> e.g. "act" would have x<sub>0</sub>="a", x<sub>1</sub>="c", and x<sub>2</sub>="t". The polynomial hash code formula is h(s) = x<sub>0</sub>a<sup>k-1</sup> + x<sub>1</sub>a<sup>k-2</sup>+...+x<sub>k-2</sub>a + x<sub>k-1</sub>. 

<p>Consider the list of English words available at <a href="https://github.com/dwyl/english-words/raw/master/words.txt">https://github.com/dwyl/english-words/raw/master/words.txt</a>. For each word, compute the hash code for a=10, 33, 37, 39, and 41. Record the number of collisions and the highest number of collisions for a word. 

<p>For example, assume your list has 5 words: the, one, little, pig, is; and the values for the hash code are 1, 1, 1, 2, 2; then you have 2 collisions (2 distinct values) and the highest number of collisions for a single word is 3. Your summary must contain the following table filled with values computed by your code.

<table border=1 align=center>
<tr>
<td></td> <td>10</td><td>33</td><td>37</td><td>39</td><td>41</td>
</tr>
<tr>
<td>Total collisions</td><td></td><td></td><td></td><td></td><td></td>
</tr>
<tr>
<td>Max collision</td><td></td><td></td><td></td><td></td><td></td>
</tr>
</table>

<p>Note: It is up to you to decide how you handle overflow; just provide a sound justification.</p>

<p>In the second part, the MAD (Multiply Add Divide) compression function c(i) = [(&alpha; i + &beta;) mod p] mod N is investigated. Recall that N is the size of the bucket array, p is a prime number larger than N, &alpha; is a positive integer, and &beta; is an integer. In addition, &alpha; and &beta; must be in the interval [0,p-1]. Use the same list of words, and apply the polynomial hash code with a=41 to obtain an integer. Then compute the values using the MAD compression function with a load factor of 80%, i.e. N = 1.2 * NumberOfWords (round to nearest 1,000); p= next prime number after N, e.g. if N=466,550 then take p=560,017; &alpha;=10,000, 100,000, and 200,000; and &beta;=50,000, and 150,000. Compute the number of collisions and highest number of collisions for the resulting 6 algorithms. Provide a table similar to the one above.

<p>Finally, make a recommendation for the values of a, &alpha; and &beta;. Feel free to suggest different values than the one tested above if you find better values supported by your numerical experiments (your TA should be able to replicate your experiments).</p> 

<p>Once the lab is complete, commit and push your changes. Your repository must containt
<ol>
<li>your code,
<li>a short summary of your findings supported by numerical experiments; feel free to use graphs to support your conclusion. The summary must be in a pdf format. 
</ol>
