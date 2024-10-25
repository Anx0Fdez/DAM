import sys
from PyQt6.QtWidgets import (QMainWindow, QApplication)


class PrimeraFiestra(QMainWindow):

    def __init__(self):
        super().__init__()

        self.show()


if __name__ == '__main__':
    aplicacion = QApplication(sys.argv)
    ventana = PrimeraFiestra()
    aplicacion.exec()


