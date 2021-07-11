class Cell {

    private var prevCell : Cell? = null
    private var row=0
    private var col=0
    private var scr=0
    enum class PrevCellType { Left, Above, Diagonal }

    private var cellType:PrevCellType? = null
    constructor()
    constructor(row:Int,col:Int, scr:Int) {
        this.col = col
        this.row = row
        this.scr = scr

    }

    constructor(row:Int,col:Int, scr:Int, prevCell:Cell,cellType:PrevCellType) {
        this.col = col
        this.row = row
        this.scr = scr
        this.prevCell = prevCell
        this.cellType = cellType
    }

    var cellPtr: Cell?
        get() = this.prevCell
        set(value){
            this.prevCell = value
        }

    var cellScore:Int
        get() = this.scr
        set(value) {
            this.scr = value
        }
    var cellRow:Int
        get() = this.row
        set(value){
            this.row = value
        }
    var cellCol:Int
        get() = this.col
        set(value){
            this.col = value
        }

    var type: PrevCellType?
        get() = this.cellType
        set(value) {
            cellType = value
        }
}