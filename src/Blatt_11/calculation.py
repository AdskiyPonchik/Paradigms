def speedup_real(T1, Tp_list):
    """Berechnet realen Speedup: S(p) = T(1) / T(p)"""
    return [T1 / Tp for Tp in Tp_list]

def effizienz_real(speedup_list, p_list):
    """Berechnet reale Effizienz: E(p) = S(p) / p"""
    return [S / p for S, p in zip(speedup_list, p_list)]

def speedup_amdahl(p_list, X):
    """Berechnet Speedup nach Amdahls Gesetz: S(p) = 1 / ((1 - X) + X / p)"""
    return [1 / ((1 - X) + X / p) for p in p_list]

def effizienz_amdahl(speedup_list, p_list):
    """Berechnet Effizienz nach Amdahls Gesetz: E(p) = S(p) / p"""
    return [S / p for S, p in zip(speedup_list, p_list)]

prozessoren = [1, 2, 4, 8, 16]
laufzeiten = [1024, 850, 787, 740, 720]
T1 = laufzeiten[0]
X = 0.5

s_real = speedup_real(T1, laufzeiten)
e_real = effizienz_real(s_real, prozessoren)

s_amdahl = speedup_amdahl(prozessoren, X)
e_amdahl = effizienz_amdahl(s_amdahl, prozessoren)

print("Speedup real:", s_real)
print("Effizienz real:", e_real)
print("Speedup Amdahl:", s_amdahl)
print("Effizienz Amdahl:", e_amdahl)
