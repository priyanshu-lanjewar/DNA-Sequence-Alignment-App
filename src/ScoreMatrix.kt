import java.util.*
import javax.swing.*


class ScoreMatrix(
    matrix: MutableList<MutableList<Cell>>,
    private var Seq1: String,
    private var Seq2: String
) {
    private var array: Array<Array<Any?>> = Array(Seq2.length) { arrayOfNulls(Seq1.length + 1) }
    private var col: Array<String?>

    companion object{
        var f=JFrame()
    }

    init {
        for (i in array.indices) {
            array[i][0] = Seq2[i]
        }
        for (i in array.indices) {

            for (j in 1 until array[0].size) {
                array[i][j] = matrix[i][j - 1].cellScore

            }
        }
        col = arrayOfNulls(Seq1.length+1)
        for (i in Seq1.indices) {
            col[i+1] = Seq1[i].toString()
        }
        col[0]="*"
    }
    fun showMatrix(){
        val icn = ImageIcon(Objects.requireNonNull(this.javaClass.getResource("dna.png")))
        f = JFrame("Score Matrix")
        f.iconImage = icn.image
        val t =  JTable(array,col)
        val s = JScrollPane(t)
        var w=26*(1+Seq1.length)
        var h=26*(1+Seq2.length)
        if(w>500 || h>500){
            h=500
            w=500
            t.autoResizeMode = JTable.AUTO_RESIZE_OFF
        }
        f.setSize(w,h)

        f.add(s)
        f.setLocationRelativeTo(null)
        f.isVisible=true
    }
}