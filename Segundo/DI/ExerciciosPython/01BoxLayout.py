import sys
from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtWidgets import QWidget, QApplication, QMainWindow, QVBoxLayout, QHBoxLayout


class CaixaColor(QWidget):
    def __init__(self, color):
        super().__init__()
        self.setAutoFillBackground(True)
        paleta = self.palette()
        paleta.setColor(QPalette.ColorRole.Window, QColor(color))
        self.setPalette(paleta)

if __name__ == "__main__":
    rojoPastel = "#FFC0CB"
    amarilloPastel = "#FFFF99"
    moradoPastel = "#CC99FF"
    verdePastel = "#99FF99"

    app = QApplication(sys.argv) # Crea una instancia de QApplication para gestionar la aplicación
    ventana = QMainWindow() # Crea una instancia de QMainWindow para gestionar la ventana principal
    ventana.setWindowTitle("Cajas de colores")
    ventana.setMinimumSize(600, 400)

    caja1 = QVBoxLayout() # Caja vertical para meter los elementos de la ventana
    caja1.addWidget(CaixaColor(rojoPastel))
    caja1.addWidget(CaixaColor(amarilloPastel))
    caja1.addWidget(CaixaColor(moradoPastel))

    caja2 = QVBoxLayout()
    caja2.addWidget(CaixaColor(verdePastel))

    caja3 = QVBoxLayout()
    caja3.addWidget(CaixaColor(rojoPastel))
    caja3.addWidget(CaixaColor(moradoPastel))

    contenedor = QWidget() # Contenedor para meter la caja vertical y que se muestre en la ventana
    contenedor.setLayout(caja1)

    contenedor2 = QWidget()
    contenedor2.setLayout(caja2)

    contenedor3 = QWidget()
    contenedor3.setLayout(caja3)

    main_layout = QHBoxLayout() # Caja vertical para meter los elementos de la ventana
    main_layout.addWidget(contenedor)
    main_layout.addWidget(contenedor2)
    main_layout.addWidget(contenedor3)

    main_widget = QWidget() # Contenedor para meter la caja vertical y que se muestre en la ventana
    main_widget.setLayout(main_layout) # Añade la caja vertical al contenedor
    ventana.setCentralWidget(main_widget) # Añade el contenedor a la ventana principal

    ventana.show()
    sys.exit(app.exec()) # Ejecuta la aplicación y espera a que se cierre la ventana para salir