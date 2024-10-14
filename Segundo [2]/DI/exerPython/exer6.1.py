def primeiros_dous_caracteres(cadea):
    # Imprime os dous primeiros caracteres
    print(cadea[:2])

def tres_ultimos_caracteres(cadea):
    # Imprime os tres últimos caracteres
    print(cadea[-3:])

def cada_dous_caracteres(cadea):
    # Imprime a cadea cada dous caracteres
    print(cadea[::2])

def cadea_inversa(cadea):
    # Imprime a cadea en sentido inverso
    print(cadea[::-1])

def cadea_sente_inversa(cadea):
    # Imprime a cadea e logo a cadea en sentido inverso
    print(cadea + cadea[::-1])

# Exemplo de uso:
cadea = "exemplo"

primeiros_dous_caracteres(cadea)  # Saída: ex
tres_ultimos_caracteres(cadea)    # Saída: plo
cada_dous_caracteres(cadea)       # Saída: eepo
cadea_inversa(cadea)              # Saída: olpmexe
cadea_sente_inversa(cadea)        # Saída: exemploolpmexe
