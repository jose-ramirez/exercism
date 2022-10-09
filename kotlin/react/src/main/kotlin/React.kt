import java.util.LinkedList

class Reactor<T> {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    fun updateGraph(start: Cell) {
        val queue = LinkedList<Cell>()
        val visited = mutableListOf<Cell>()
        queue.add(start)
        visited.add(start)

        while(queue.isNotEmpty()) {
            val cell = queue.removeFirst()
            cell.outputs.forEach{
                if (it is ComputeCell) {
                    it.updateValue()
                }
                if (!visited.contains(it)) {
                    visited.add(it)
                    queue.add(it)
                }
            }
        }
    }

    open inner class Cell(
        v: T,
        val inputs: MutableList<Cell> = mutableListOf(),
        val outputs: MutableList<Cell> = mutableListOf()) {

        var value = v
            set(value) {
                field = value
                updateGraph(this)
            }
    }

    inner class InputCell(v: T): Cell(v)

    inner class ComputeCell(
        vararg inputCells: Cell,
        var computeFunction: (values: List<T>) -> T)
        : Cell(
            v = computeFunction(inputCells.map { it.value }),
            inputs = inputCells.toMutableList()
        ) {

        private var count = 0

        private var callbacks = mutableListOf<(values: T) -> Boolean>()

        init{
            this.inputs.forEach { it.outputs.add(this) }
        }

        fun addCallback(callback: (values: T) -> Boolean): Subscription {
            callbacks.add(callback)
            return object : Subscription {
                override fun cancel() {
                    callbacks.remove(callback)
                }
            }
        }

        fun updateValue() {
            count += 1
            if (count == this.inputs.size) {
                val newValue = this.computeFunction(this.inputs.map { it.value })
                if (newValue != this.value) {
                    this.value = newValue
                    callbacks.forEach { it(this.value) }
                }
                count = 0
            }
        }
    }
}
