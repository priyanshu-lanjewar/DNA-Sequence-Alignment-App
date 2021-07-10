import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class AlignmentCall {

    companion object {
        var SeqAl1 = mutableListOf<Char>()
        var SeqAl2 = mutableListOf<Char>()
        lateinit var matrix:MutableList<MutableList<Cell>>

        fun makeCall(Sq1: String, Sq2: String, sim:Int, notSim:Int, gap:Int): String {
            SeqAl1.clear()
            SeqAl2.clear()
            val alignment = DnaSequenceAlignment()
            println(Sq1)
            println(Sq2)
            matrix = alignment.initProcess(Sq1, Sq2, sim, notSim, gap)
            var arr= arrayListOf<ArrayList<JvmType.Object>>()
            alignment.trackBack(matrix, Sq1, Sq2, SeqAl1, SeqAl2)
            return "  "+SeqAl1.toString().replace(',', ' ').removePrefix("[").removeSuffix("]").reversed() + "  \n  " + SeqAl2.toString()
                .replace(',', ' ').removePrefix("[").removeSuffix("]").reversed()+"  "
        }
        lateinit var table:MutableList<MutableList<Cell>>

    }
}