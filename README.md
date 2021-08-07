# DNA Sequence Alignmen Application

- A DNA Sequence is observed to be a String of Character ‘A’ , ‘G’ , ‘C’ and ‘T’ , where each character represents a particular nucleotide.
- Finding similarities in 2 or more DNA sequences is one of the very important computation in Bioinformatics.
- Alignment can be used to capture various facts about the sequences aligned, such as common evolutionary descent or common structural functions.
- If 2 sequences that are aligned, shares a common ancestor, mismatches can be interpreted as point of mutations and gaps
– indels (Insertion or deletion).


## Inputs 
- Two DNA Sequence : Seq1 & Seq2 as String
- Match/ Mismatch Score
-Similarity Score as Int
-Dissimilarity Score as Int o Gap Score as Int

## Goal / Objective / Desired Output 
- To find the Best Alignment between DNA Sequence 1 and DNA Sequence 2 with minimum number of changes
to convert one Sequence to Other*.


## Sample Input and Output 
- Input : 
o Sequence 1 : GATTCATACCTG 
o Sequence 2 : GATCATCAG 
o Similarity score : +1 
o Dissimilarity score : -1 
o Gap score : 0
- Output:  <br>
G A T T C A T _ A C C T G <br>
G A _ T C A T C A _ _ _ G <br>

## Mathematical Formula and Model 
- Brute force Approach to solve this problem is to enumerate all the subsequence of Sequence and comparing it with Subsequence of Sequence 2 after performing similar operation on it and then Selecting the Longest one and then adding ‘_’ to align it .
- But doing this will increase time complexity : 
- Eg :  <br>
-S1=GATT  <br>
-S2=GAAT <br>
- Step 1: computing Subsequence set  <br>
subS1 = {G, A , T , GA, GT, AT, GAT, GTT, GATT}  <br>
subS2 = {G, A, T, GA, GT, AA, AT, GAT, GAAT} <br>
- Step 2: comparing and listing common subsequence  <br>
Common = {G , A , T, GA, GT, AT, GAT}
- Step 3: selecting maximum length subsequence  <br>
maxLengthSubSequence = GAT
- Step 4: Aligning it by adding ‘ _ ‘S  <br>
S1 : G _ A T T <br>
S2 : G A A _ T <br>
OR many different alignments are possible.
- But this will take exponential time complexity.

## Optimised Approach using Dynamic Programing
- This Problem can be solved in lesser time complexity by using Dynamic Programming.
- This Sequence Alignment Problem using Dynamic Programming is based on Needleman Wunsch algorithm.
- Let Sequence 1 be of length i+1 = > Sequence1[0..i] 
- Let Sequence 2 be of length j+1 = > Sequence2[0..j] 
- If gap score = 0, dissimilarity score = -1 and similarity score = 1 => Matrix[i+1,j+1] will have length of longest common subsequence, we have nothing to do with it here. Our interest is to find best Alignment using score.
- A Score Matrix is constructed of dimension [i+1][j+1]

```sh
 Formula/ Approach :
Initialize matrix[0][0] = 0; 
Formula: 
• If index of row (i) = 0 
==> Matrix[0][i] = matrix[0][i-1] + gap score
• If index of row (i) = 0 
==> Matrix[i][0] = matrix[i-1][0] + gap score
• If index of row(i) == index of column (j)
==> Matrix[i][j] = Matrix[i-1][j-1] + Similarity Score //sim score + diagonal element
• If index of row(i) != index of column(j) 
==> Diagonal = Matrix[i-1][j-1] + ( Simalirity score or Dissimalarity Score accordingly) 
==> Left = Matrix[i][i-1] + gap Score 
==> Above = Matrix[i-1][j] + gap Score
==> Matrix[i][j] = Max of(Diagonal,Above,Left)
```


## Sequence Alignment Process Trackbacking 
- A diagonal arrow represents a match or mismatch, so the letter of the column and the letter of the row of the origin cell will align.
- A horizontal or vertical arrow represents an indel. Horizontal arrows will align a gap ("_") to the letter of the row (the "side" sequence), vertical arrows will align a gap to the letter of the column (the "top" sequence)
- If there are multiple arrows to choose from, they represent a branching of the alignments. If two or more branches all belong to paths from the bottom right to the top left cell, they are equally viable alignments.

## Real-life applications 
- Sequence alignments are useful in bioinformatics for identifying sequence similarity, producing phylogenetic trees, and developing homology models of protein structures.
- Sequenced RNA, such as expressed sequence tags and fulllength mRNAs, can be aligned to a sequenced genome to find where there are genes and get information about alternative splicing and RNA Editing.
- Sequence alignment is also a part of genome assembly, where sequences are aligned to find overlap so that contigs (long stretches of sequence) can be formed.
- The methods used for biological sequence alignment have also found applications in other fields, most notably in natural language processing and in social sciences, where the Needleman-Wunsch algorithm is usually referred to as Optimal matching.
- Techniques that generate the set of elements from which words will be selected in natural-language generation algorithms have borrowed multiple sequence alignment techniques from bioinformatics to produce linguistic versions of computer-generated mathematical proofs.
- Business and marketing research has also applied multiple sequence alignment techniques in analysing series of purchases over time.
