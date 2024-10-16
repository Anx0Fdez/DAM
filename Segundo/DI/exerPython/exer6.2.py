def inserir_caracter_entre_letras(cadea, caracter):
    """
    Insere o caracter entre cada letra da cadea.

    Args:
        cadea (str): A cadea de caracteres orixinal.
        caracter (str): O caracter a inserir entre cada letra.

    Returns:
        None
    """
    resultado = caracter.join(cadea)
    print(resultado)

def reemplazar_espacios(cadea, caracter):
    """
    Reemplaza tódolos espacios na cadea polo caracter dado.

    Args:
        cadea (str): A cadea de caracteres orixinal.
        caracter (str): O caracter a usar para reemplazar os espacios.

    Returns:
        None
    """
    resultado = cadea.replace(' ', caracter)
    print(resultado)

def reemplazar_dixitos(cadea, caracter):
    """
    Reemplaza tódolos díxitos na cadea polo caracter dado.

    Args:
        cadea (str): A cadea de caracteres orixinal.
        caracter (str): O caracter a usar para reemplazar os díxitos.

    Returns:
        None
    """
    resultado = ''.join([caracter if char.isdigit() else char for char in cadea])
    print(resultado)

def inserir_caracter_cada_tres_dixitos(cadea, caracter):
    """
    Insere o caracter cada tres díxitos na cadea.

    Args:
        cadea (str): A cadea de caracteres orixinal.
        caracter (str): O caracter a inserir cada tres díxitos.

    Returns:
        None
    """
    resultado = ''.join([caracter if i % 3 == 0 and i != 0 else char for i, char in enumerate(cadea, 1)])
    print(resultado)

# Exemplos de uso
cadea = "separar"
inserir_caracter_entre_letras(cadea, ',')
cadea = "meu arquivo de texto.txt"
reemplazar_espacios(cadea, '_')
cadea = "Súa clave é: 1540"
reemplazar_dixitos(cadea, 'X')
cadea = "2552552550"
inserir_caracter_cada_tres_dixitos(cadea, '.')