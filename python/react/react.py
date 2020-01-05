class InputCell:
    def __init__(self, initial_value):
        self._value = initial_value
        self.outputs = []

    def set_output(self, output_cell):
        if output_cell is not None:
            self.outputs.append(output_cell)

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, value):
        self._value = value
        if self.outputs:
            for output in self.outputs:
                output.update()


class ComputeCell:
    def __init__(self, inputs, compute_function):
        self.inputs = inputs
        for i in self.inputs:
            i.set_output(self)
        self.outputs = []
        self.callbacks = []
        self.total_updated_inputs = 0
        self.compute_function = compute_function
        self._value = self.compute_function([i.value for i in inputs])

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, value):
        self._value = value
        if self.outputs:
            for output in self.outputs:
                output.update()

    def update(self):
        old_value = self.value
        self.total_updated_inputs += 1
        if self.total_updated_inputs == len(self.inputs):
            self.value = self.compute_function([i.value for i in self.inputs])
            if self.callbacks and self.value != old_value:
                for cb in self.callbacks:
                    cb(self.value)
            self.total_updated_inputs = 0

    def set_output(self, output_cell):
        self.outputs.append(output_cell)

    def add_callback(self, callback):
        self.callbacks.append(callback)

    def remove_callback(self, callback):
        try:
            self.callbacks.remove(callback)
        except ValueError:
            pass
