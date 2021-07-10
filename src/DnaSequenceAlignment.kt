import kotlin.math.max

class DnaSequenceAlignment {
    fun initProcess(seq1:String, seq2:String, sim:Int, notSim:Int, gap:Int):MutableList<MutableList<Cell>>{
        val m = seq1.length;
        val n = seq2.length;

        val matrix = MutableList(n){
                _ -> MutableList(m){
                _ -> Cell()
        }
        }

        for(i in 0 until matrix[0].size){
            matrix[0][i]= Cell(0,i,i*gap)
        }
        for(i in 0 until matrix.size){
            matrix[i][0] = Cell(i,0,i*gap)
        }

        for (j in 1 until matrix.size){
            for (i in 1 until matrix[0].size){
                matrix[j][i] = getMax(i,j,seq1,seq2,matrix,sim,notSim,gap);
            }
        }

        return matrix;

    }

    private fun getMax(i: Int, j: Int, seq1: String, seq2: String, matrix: MutableList<MutableList<Cell>>, sim: Int, notSim: Int, gap: Int): Cell {
        var tmp = Cell();
        val Gap = gap
        val Sim = if (seq1[i] == seq2[j]) sim
        else notSim

        val m1: Int = matrix[j-1][i-1].cellScore + Sim
        val m2: Int = matrix[j][i-1].cellScore + Gap
        val m3: Int = matrix[j-1][i].cellScore + Gap;

        val maxM = max(m1, max(m2,m3))

        when(maxM){
            m1 ->{
                tmp = Cell(j,i,m1,matrix[j-1][i-1],Cell.PrevCellType.Diagonal)
            }
            m2 ->{
                tmp = Cell(j,i,m2,matrix[j][i-1],Cell.PrevCellType.Left)
            }
            m3 ->{
                tmp = Cell(j,i,m3,matrix[j-1][i],Cell.PrevCellType.Above)
            }
        }
        return  tmp
    }

    fun trackBack(matrix:MutableList<MutableList<Cell>>,sq1:String,sq2:String,Seq1:MutableList<Char>,Seq2:MutableList<Char>){
        var currCell = matrix[sq2.length - 1][sq1.length - 1]
        while (currCell.cellPtr!=null){
            when(currCell.type){
                Cell.PrevCellType.Diagonal ->{

                    Seq1.add(sq1[currCell.cellCol])
                    Seq2.add((sq2[currCell.cellRow]))
                }
                Cell.PrevCellType.Left ->{

                    Seq1.add(sq1[currCell.cellCol])
                    Seq2.add('_');
                }
                Cell.PrevCellType.Above ->{

                    Seq1.add('_')
                    Seq2.add((sq2[currCell.cellRow]))
                }
            }
            currCell = currCell.cellPtr!!
        }
    }
}