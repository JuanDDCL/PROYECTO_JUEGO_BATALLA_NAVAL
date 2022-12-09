import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nc, nf, nb, bhj1 = 0, bhj2 = 0, cb1 = 0, cb2 = 0, cb3 = 0, cb4 = 0, cb5 = 0, cb6 = 0, cb7 = 0, cb8 = 0;
        char tablero1[][], tablero2[][], vacio1[][], vacio2[][], ejemplo[][], agua = '▭', barco1 = '1', barco2 = '2', barco3 = '3', barco4 = '4', ca = '■', bh = '☠';
        boolean ok = true, pb = true,det1=true,det2=true;
        String nj1, nj2;
        Scanner teclado = new Scanner(System.in);
        Scanner leer = new Scanner(System.in);
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        » BIENVENIDO AL JUEGO «        ║");
        System.out.println("║           » BATALLA NAVAL «           ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║════════» SIMBOLOGIA DEL JUEGO «═══════║");
        System.out.println("         · AGUA = ▭");
        System.out.println("         · PRIMER BARCO = 1");
        System.out.println("         · SEGUNDO BARCO = 2");
        System.out.println("         · TERCER BARCO = 3");
        System.out.println("         · CUARTO BARCO = 4");
        System.out.println("         · COORDENADAS ATACADAS = ■");
        System.out.println("         · BARCOS HUNDIDOS = ☠");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║════════════» REGLAMENTO «═════════════║");
        System.out.println("\n Ⅰ EL TABLERO DE TAMAÑO MINIMO QUE");
        System.out.println("    PUEDES CREAR ES DE 4x4");
        System.out.println(" Ⅱ EVITE LANZAR ATAQUE A COORDENADAS");
        System.out.println("    QUE YA FUERON ATACADAS ANTERIORMENTE");
        System.out.println(" Ⅲ EL PRIMER JUGADOR EN HUNDIR TODOS");
        System.out.println("    LOS BARCOS ENEMIGOS GANA");
        System.out.println(" Ⅳ SOLAMENTE SI HAS DESTRUIDO UN BARCO");
        System.out.println("    POR COMPLETO SE TE SUMARA 1 PUNTO");
        System.out.println(" Ⅴ SOLO INGRESAR LOS DATOS QUE SE");
        System.out.println("    SOLICITAN\n");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("╠══» INGRESE NOMBRE DE LOS JUGADORES «══╣");
        System.out.println("        » NOMBRE DEL JUGADOR UNO «");
        nj1 = leer.nextLine();
        System.out.println("        » NOMBRE DEL JUGADOR DOS «");
        nj2 = leer.nextLine();
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("╠═══» INGRESE EL TAMAÑO DEL TABLERO «═══╣");
        System.out.println("          » CANTIDAD DE FILAS «");
        nf = teclado.nextInt();
        System.out.println("         » CANTIDAD DE COLUMNAS «");
        nc = teclado.nextInt();
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("╠═════» INGRESE CANTIDAD DE BARCOS «════╣");
        System.out.println("          CON LA QUE DESEA JUGAR");
        System.out.println("            ( MAX.4 - MIN.1 )");
        nb = teclado.nextInt();
        System.out.println("╚═══════════════════════════════════════╝");
        tablero1 = new char[nf][nc];
        tablero2 = new char[nf][nc];
        vacio1 = new char[nf][nc];
        vacio2 = new char[nf][nc];
        ejemplo = new char[nf][nc];
        for (int i = 0; i < nf; i++) {//LLENADO DE TABLEROS
            for (int j = 0; j < nc; j++) {
                tablero1[i][j] = agua;
                vacio1[i][j] = agua;
                tablero2[i][j] = agua;
                vacio2[i][j] = agua;
                ejemplo[i][j] = '◇';
            }
        }
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println(" » EJEMPLO DEL TABLERO GENERADO ( " + nf + "x" + nc + " )");
        for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO DE EJEMPLO
            for (int j = 0; j < nc; j++) {
                System.out.print(" " + ejemplo[i][j]);
            }
            System.out.println("");
        }
        System.out.println(" » EJEMPLO DE COMO COLOCAR COORDENADAS");
        System.out.println("   PARA BARCOS CON LONGITUD DE 1");
        System.out.println("   FILA = " + nf + " x COLUMNA = " + nc);
        System.out.println(" » BARCO COLOCADO EN LAS COORDENADAS");
        System.out.println("   → (" + nf + "," + nc + ") ←");
        for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO EJEMPLO CON BARCO
            char ej = '◆';
            for (int j = 0; j < nc; j++) {
                ejemplo[nf - 1][nc - 1] = ej;
                System.out.print(" " + ejemplo[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n╚═══════════════════════════════════════╝");

        while (ok) {
            while (pb) {
                int aux1 = 0;
                boolean auxb1 = true, auxb2 = true, auxb3 = true, auxb4 = true, auxb5 = true, auxb6 = true, auxb7 = true, auxb8 = true;
                while (aux1 < 1) {
                    aux1++;
                    System.out.println("\n╔═══════════════════════════════════════╗");
                    System.out.println(" » Posicion para los barcos de \n   " + nj1);
                    int tb1 = 0, tb2 = 0, tb3 = 0, tb4 = 0;
                    if (nb >= 1) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   primer barco ( LONGITUD DE 1 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        while (auxb1) {
                            if (tb1 < 1) {
                                tablero1[cordsfila - 1][cordscol - 1] = barco1;
                                tb1++;
                            }
                            if (tb1 == 1) {
                                auxb1 = false;
                            }
                        }//FIN AUXB1
                    }
                    if (nb >= 2) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   segundo barco ( LONGITUD DE 2 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb2) {
                            if (tb2 < 2) {
                                tablero1[cordsfila - 1][cordscol - 1] = barco2;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb2++;
                                for (int i = 1; i < 2; i++) {
                                    if (direccion == 1) {
                                        tablero1[val1 - i][val2] = barco2;
                                    }
                                    if (direccion == 2) {
                                        tablero1[val1 + i][val2] = barco2;
                                    }
                                    if (direccion == 3) {
                                        tablero1[val1][val2 - i] = barco2;
                                    }
                                    if (direccion == 4) {
                                        tablero1[val1][val2 + i] = barco2;
                                    }
                                }
                            }
                            if (tb2 == 2) {
                                auxb2 = false;
                            }
                        }//FIN AUXB2
                    }
                    if (nb >= 3) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   tercer barco ( LONGITUD DE 3 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb3) {
                            if (tb3 < 3) {
                                tablero1[cordsfila - 1][cordscol - 1] = barco3;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb3++;
                                for (int i = 1; i < 3; i++) {
                                    if (direccion == 1) {
                                        tablero1[val1 - i][val2] = barco3;
                                    }
                                    if (direccion == 2) {
                                        tablero1[val1 + i][val2] = barco3;
                                    }
                                    if (direccion == 3) {
                                        tablero1[val1][val2 - i] = barco3;
                                    }
                                    if (direccion == 4) {
                                        tablero1[val1][val2 + i] = barco3;
                                    }
                                }
                            }
                            if (tb3 == 3) {
                                auxb3 = false;
                            }
                        }//FIN AUXB3
                    }
                    if (nb >= 4) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   cuarto barco ( LONGITUD DE 4 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb4) {
                            if (tb4 < 4) {
                                tablero1[cordsfila - 1][cordscol - 1] = barco4;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb4++;
                                for (int i = 1; i < 4; i++) {
                                    if (direccion == 1) {
                                        tablero1[val1 - i][val2] = barco4;
                                    }
                                    if (direccion == 2) {
                                        tablero1[val1 + i][val2] = barco4;
                                    }
                                    if (direccion == 3) {
                                        tablero1[val1][val2 - i] = barco4;
                                    }
                                    if (direccion == 4) {
                                        tablero1[val1][val2 + i] = barco4;
                                    }
                                }
                            }
                            if (tb4 == 4) {
                                auxb4 = false;
                            }
                        }//FIN AUXB4
                    }
                    System.out.println("╚═══════════════════════════════════════╝");
                }//FIN AUX PRINCIPAL1
                while (aux1 < 2) {
                    aux1++;
                    System.out.println("\n╔═══════════════════════════════════════╗");
                    System.out.println(" » Posicion para los barcos de \n   " + nj2);
                    int tb1 = 0, tb2 = 0, tb3 = 0, tb4 = 0;
                    if (nb >= 1) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   primer barco ( LONGITUD DE 1 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        while (auxb5) {
                            if (tb1 < 1) {
                                tablero2[cordsfila - 1][cordscol - 1] = barco1;
                                tb1++;
                            }
                            if (tb1 == 1) {
                                auxb5 = false;
                            }
                        }//FIN AUXB5
                    }
                    if (nb >= 2) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   segundo barco ( LONGITUD DE 2 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb6) {
                            if (tb2 < 2) {
                                tablero2[cordsfila - 1][cordscol - 1] = barco2;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb2++;
                                for (int i = 1; i < 2; i++) {
                                    if (direccion == 1) {
                                        tablero2[val1 - i][val2] = barco2;
                                    }
                                    if (direccion == 2) {
                                        tablero2[val1 + i][val2] = barco2;
                                    }
                                    if (direccion == 3) {
                                        tablero2[val1][val2 - i] = barco2;
                                    }
                                    if (direccion == 4) {
                                        tablero2[val1][val2 + i] = barco2;
                                    }
                                }
                            }
                            if (tb2 == 2) {
                                auxb6 = false;
                            }
                        }//FIN AUXB6
                    }
                    if (nb >= 3) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   tercer barco ( LONGITUD DE 3 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb7) {
                            if (tb3 < 3) {
                                tablero2[cordsfila - 1][cordscol - 1] = barco3;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb3++;
                                for (int i = 1; i < 3; i++) {
                                    if (direccion == 1) {
                                        tablero2[val1 - i][val2] = barco3;
                                    }
                                    if (direccion == 2) {
                                        tablero2[val1 + i][val2] = barco3;
                                    }
                                    if (direccion == 3) {
                                        tablero2[val1][val2 - i] = barco3;
                                    }
                                    if (direccion == 4) {
                                        tablero2[val1][val2 + i] = barco3;
                                    }
                                }
                            }
                            if (tb3 == 3) {
                                auxb7 = false;
                            }
                        }//FIN AUXB7
                    }
                    if (nb >= 4) {
                        System.out.println(" » Seleciona las coordenadas de tu\n   cuarto barco ( LONGITUD DE 4 )");
                        System.out.println(" ↓ FILA ↓");
                        int cordsfila = teclado.nextInt();
                        System.out.println(" ↓ COLUMNA ↓");
                        int cordscol = teclado.nextInt();
                        System.out.println(" ↓ COLOCA HACIA QUE DIRECCION ↓");
                        System.out.println("   QUEIRES QUE CONTINUE EL BARCO");
                        System.out.println("   1 = ARRIBA ");
                        System.out.println("   2 = ABAJO ");
                        System.out.println("   3 = IZQUIERDA ");
                        System.out.println("   4 = DERECHA ");
                        int direccion = teclado.nextInt();
                        while (auxb8) {
                            if (tb4 < 4) {
                                tablero2[cordsfila - 1][cordscol - 1] = barco4;
                                int val1 = cordsfila - 1;
                                int val2 = cordscol - 1;
                                tb4++;
                                for (int i = 1; i < 4; i++) {
                                    if (direccion == 1) {
                                        tablero2[val1 - i][val2] = barco4;
                                    }
                                    if (direccion == 2) {
                                        tablero2[val1 + i][val2] = barco4;
                                    }
                                    if (direccion == 3) {
                                        tablero2[val1][val2 - i] = barco4;
                                    }
                                    if (direccion == 4) {
                                        tablero2[val1][val2 + i] = barco4;
                                    }
                                }
                            }
                            if (tb4 == 4) {
                                auxb8 = false;
                            }
                        }//FIN AUXB8
                    }
                    System.out.println("╚═══════════════════════════════════════╝");
                }//FIN AUX PRINCIPAL PARTE 2
                pb = false;
            }//FIN DE PB
            while (det1) {
                System.out.println("\n╔═══════════════════════════════════════╗");
                System.out.println(" » Turno de " + nj1 + " «");
                System.out.println("   Llevas " + bhj1 + " barcos hundidos de " + nb);
                System.out.println(" ↓ TU TABLERO ↓");

                for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO DEL JUGADOR 1
                    for (int j = 0; j < nc; j++) {
                        System.out.print(" " + tablero1[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("\n ↓ TABLERO ENEMIGO ↓");
                for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 2
                    for (int j = 0; j < nc; j++) {
                        System.out.print(" " + vacio2[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("Ingrese las coordenadas que deseas atacar");
                System.out.println(" ↓ FILA ↓");
                int cordsfila = teclado.nextInt();
                System.out.println(" ↓ COLUMNA ↓");
                int cordscol = teclado.nextInt();
                if (tablero2[cordsfila - 1][cordscol - 1] == barco1 || tablero2[cordsfila - 1][cordscol - 1] == barco2 || tablero2[cordsfila - 1][cordscol - 1] == barco3 || tablero2[cordsfila - 1][cordscol - 1] == barco4) {
                    System.out.println(" TU PROYECTIL HA SIDO CERTERO");
                    if (tablero2[cordsfila - 1][cordscol - 1] == barco1) {

                        if (cb1 < 1) {
                            cb1++;
                            tablero2[cordsfila - 1][cordscol - 1] = bh;
                            vacio2[cordsfila - 1][cordscol - 1] = bh;
                            bhj1++;
                        }
                    }
                    if (tablero1[cordsfila - 1][cordscol - 1] == barco2) {

                        if (cb2 < 2) {
                            cb2++;
                            tablero2[cordsfila - 1][cordscol - 1] = bh;
                            vacio2[cordsfila - 1][cordscol - 1] = bh;
                            if(cb2 ==2){
                                bhj1++;
                            }
                        }
                    }
                    if (tablero2[cordsfila - 1][cordscol - 1] == barco3) {

                        if (cb3 < 3) {
                            cb3++;
                            tablero2[cordsfila - 1][cordscol - 1] = bh;
                            vacio2[cordsfila - 1][cordscol - 1] = bh;
                            if(cb3 ==3){
                                bhj1++;
                            }
                        }
                    }
                    if (tablero2[cordsfila - 1][cordscol - 1] == barco4) {

                        if (cb4 < 4) {
                            cb4++;
                            tablero2[cordsfila - 1][cordscol - 1] = bh;
                            vacio2[cordsfila - 1][cordscol - 1] = bh;
                            if(cb4 ==4){
                                bhj1++;
                            }
                        }
                    }
                    for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 2
                        for (int j = 0; j < nc; j++) {
                            System.out.print(" " + vacio2[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println(" LLEVAS " + bhj1 + " BARCOS HUNDIDOS");
                } else {
                    tablero2[cordsfila - 1][cordscol - 1] = ca;
                    vacio2[cordsfila - 1][cordscol - 1] = ca;
                    System.out.println(" NO HAS IMPACTADO CON NINGUN BARCO");
                    for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 1
                        for (int j = 0; j < nc; j++) {
                            System.out.print(" " + vacio2[i][j]);
                        }
                        System.out.println("");
                    }
                }
                System.out.println("\n╚═══════════════════════════════════════╝");
                if (bhj1 == nb) {
                    System.out.println("╔═══════════════════════════════════════╗");
                    System.out.println(" !FELICIDADES " + nj1 + " HAS GANADO¡ ");
                    System.out.println("╚═══════════════════════════════════════╝");
                    ok = false;
                }
                if(ok==false){
                    det1=false;
                    det2=false;
                }else{
                    det1=false;
                    det2=true;
                }
            }//FIN TURNO 1
            while (det2) {
                System.out.println("\n╔═══════════════════════════════════════╗");
                System.out.println(" » Turno de " + nj2 + " «");
                System.out.println("   Llevas " + bhj2 + " barcos hundidos de " + nb);
                System.out.println(" ↓ TU TABLERO ↓");

                for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO DEL JUGADOR 2
                    for (int j = 0; j < nc; j++) {
                        System.out.print(" " + tablero2[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("\n ↓ TABLERO ENEMIGO ↓");
                for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 1
                    for (int j = 0; j < nc; j++) {
                        System.out.print(" " + vacio1[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("Ingrese las coordenadas que deseas atacar");
                System.out.println(" ↓ FILA ↓");
                int cordsfila = teclado.nextInt();
                System.out.println(" ↓ COLUMNA ↓");
                int cordscol = teclado.nextInt();
                if (tablero1[cordsfila - 1][cordscol - 1] == barco1 || tablero1[cordsfila - 1][cordscol - 1] == barco2 || tablero1[cordsfila - 1][cordscol - 1] == barco3 || tablero1[cordsfila - 1][cordscol - 1] == barco4) {
                    System.out.println(" TU PROYECTIL HA SIDO CERTERO");
                    if (tablero1[cordsfila - 1][cordscol - 1] == barco1) {

                        if (cb5 < 1) {
                            cb5++;
                            tablero1[cordsfila - 1][cordscol - 1] = bh;
                            vacio1[cordsfila - 1][cordscol - 1] = bh;
                            bhj2++;
                        }
                    }
                    if (tablero1[cordsfila - 1][cordscol - 1] == barco2) {

                        if (cb6 < 2) {
                            cb6++;
                            tablero1[cordsfila - 1][cordscol - 1] = bh;
                            vacio1[cordsfila - 1][cordscol - 1] = bh;
                            if(cb6 ==2){
                                bhj2++;
                            }
                        }
                    }
                    if (tablero1[cordsfila - 1][cordscol - 1] == barco3) {

                        if (cb7 < 3) {
                            cb7++;
                            tablero1[cordsfila - 1][cordscol - 1] = bh;
                            vacio1[cordsfila - 1][cordscol - 1] = bh;
                            if(cb7 ==3){
                                bhj2++;
                            }
                        }
                    }
                    if (tablero1[cordsfila - 1][cordscol - 1] == barco4) {

                        if (cb8 < 4) {
                            cb8++;
                            tablero1[cordsfila - 1][cordscol - 1] = bh;
                            vacio1[cordsfila - 1][cordscol - 1] = bh;
                            if(cb8 ==4){
                                bhj2++;
                            }
                        }
                    }
                    for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 1
                        for (int j = 0; j < nc; j++) {
                            System.out.print(" " + vacio1[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println(" LLEVAS " + bhj2 + " BARCOS HUNDIDOS");
                } else {
                    tablero1[cordsfila - 1][cordscol - 1] = ca;
                    vacio1[cordsfila - 1][cordscol - 1] = ca;
                    System.out.println(" NO HAS IMPACTADO CON NINGUN BARCO");
                    for (int i = 0; i < nf; i++) {//IMPRIMIR TABLERO OCULTO DEL JUGADOR 1
                        for (int j = 0; j < nc; j++) {
                            System.out.print(" " + vacio1[i][j]);
                        }
                        System.out.println("");
                    }
                }
                System.out.println("\n╚═══════════════════════════════════════╝");
                if (bhj2 == nb) {
                    System.out.println("╔═══════════════════════════════════════╗");
                    System.out.println(" !FELICIDADES " + nj2 + " HAS GANADO¡ ");
                    System.out.println("╚═══════════════════════════════════════╝");
                    ok = false;
                }
                if(ok==false){
                    det1=false;
                    det2=false;
                }else{
                    det1=true;
                    det2=false;
                }
            }//FIN TURNO 2
        }//FIN DE OK
    }
}