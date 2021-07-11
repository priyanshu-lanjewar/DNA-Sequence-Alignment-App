import java.util.*
import javax.swing.*


class ScoreMatrix{
    lateinit var array: Array<Array<Any?>>
    lateinit var col: Array<String?>
    lateinit var matrix: MutableList<MutableList<Cell>>
    lateinit var Seq1: String
    lateinit var Seq2: String
    companion object{
        var f=JFrame()
    }

    constructor(){

    }
    constructor(matrix:MutableList<MutableList<Cell>>, Seq1:String,Seq2:String){
        this.matrix = matrix
        this.Seq1=Seq1
        this.Seq2 = Seq2
        array = Array(Seq2.length) { arrayOfNulls(Seq1.length + 1) }

        for (i in array.indices) {
            array[i][0] = Seq2.get(i)
        }

        for (i in array.indices) {

            for (j in 1 until array[0].size) {
                array[i][j] = matrix.get(i).get(j - 1).cellScore

            }
        }
        col = arrayOfNulls(Seq1.length+1)
        for (i in Seq1.indices) {
            col[i+1] = Seq1.get(i).toString()
        }
        col[0]="*"

    }
    fun showMatrix(){
        val icn = ImageIcon(Objects.requireNonNull(this.javaClass.getResource("dna.png")))
        f = JFrame("Score Matrix")
        f.iconImage = icn.image
        val t =  JTable(array,col)
        val s = JScrollPane(t);
        var w=26*(1+Seq1.length)
        var h=26*(1+Seq2.length)
        if(w>500 || h>500){
            h=500
            w=500
            t.autoResizeMode = JTable.AUTO_RESIZE_OFF
        }
        f.setSize(w,h)

        f.add(s);
        f.setLocationRelativeTo(null)
        f.isVisible=true
    }
}