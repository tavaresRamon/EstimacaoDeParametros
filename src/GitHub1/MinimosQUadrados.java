package GitHub1;

import java.util.ArrayList;
import java.util.List;

public class MinimosQUadrados {
    public static void main(String[] args) {
        //VALORES DE X E Y UTILIZADOS COMO EXEMPLO:
        List<Double> varx = new ArrayList<>(List.of(907.0, 926.0, 506.0, 741.0, 789.0, 889.0, 874.0, 510.0, 529.0, 420.0));
        List<Double> vary = new ArrayList<>(List.of(11.2, 11.05, 6.84, 9.21, 9.42, 10.08, 9.45, 6.73, 7.24, 6.12));
        double somadeX = varx.stream().mapToDouble(Double::doubleValue).sum();
       
        double somadeY = vary.stream().mapToDouble(Double::doubleValue).sum();
       
        double mediaX = somadeX / varx.size();
        
        double mediaY = somadeY / vary.size();
       

        ArrayList<Double> subDex = new ArrayList<>();
        for (Double aDouble : varx) {
            double subXi = aDouble - mediaX;
            subDex.add(subXi);
        }
        
        double subDeXi = subDex.stream().filter(n -> n > 0 ? n.isNaN() : n == 0).mapToDouble(Double::doubleValue).sum();
        double mediaDeXi = subDeXi / subDex.size();
        


        ArrayList<Double> xAoQuadrado = new ArrayList<>();
        for (int i = 0; i < varx.size(); i++) {
            double pow = Math.pow(subDex.get(i), 2);
            xAoQuadrado.add(pow);
        }
        
        double somaXAoQuadrado = xAoQuadrado.stream().mapToDouble(Double::doubleValue).sum();
        double mediaXAoQuadrado = somaXAoQuadrado / xAoQuadrado.size();
       

        ArrayList<Double> subDey = new ArrayList<>();
        for (Double yis : vary) {
            double subYi = yis - mediaY;
            subDey.add(subYi);
        }
       
        double somaYzero = subDey.stream().filter(n -> n > 0 ? n.isNaN() : n == 0).mapToDouble(Double::doubleValue).sum();
        double mediaYzero = somaYzero / subDey.size();
       


        ArrayList<Double> produtoSubXeY = new ArrayList<>();
        for (int i = 0; i < vary.size(); i++) {
            double produtoFinal = subDex.get(i) * subDey.get(i);
            produtoSubXeY.add(produtoFinal);
        }
       
        double somaXY = produtoSubXeY.stream().mapToDouble(Double::doubleValue).sum();
        double mediaXY = somaXY / produtoSubXeY.size();
       


     //ESTIMAÇÃO DOS PARÂMETROS VIA MÉTODO DOS MÍNIMOS QUADRADOS
        double parametroB1 = (somaXY / somaXAoQuadrado);
        double parametroB0 = mediaY - (parametroB1 * mediaX);
      

    }
}
//// SCRIPT DOS RESULTADOS, OBTIDOS ATRAVÉS DOS VALORES INSERIDOS NOS PARÂMETROS (X) E (Y) COMO EXEMPLO:
// System.out.printf("Soma de x [%.3f]%n", somadeX);
// System.out.printf("Soma de y [%.3f]%n", somadeY);
//System.out.printf("Médias de x [%.3f]%n", mediaX);
// System.out.printf("Médias de Y [%.3f]%n", mediaY);
//
//for (Double dex : subDex) {
//            System.out.printf("Todos os valores de (Xi - Media) = [%.3f]%n", dex);
//        }
//System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.printf("Soma  de (xi - media): [%.2f]%n", subDeXi);
//        System.out.printf("Média 0 de (xi - media): [%.2f]%n", mediaDeXi);
//        System.out.println("-----------------------------------------------------------------------------------------------------");
//for (Double aDouble : xAoQuadrado) {
//
//            System.out.printf("Todos os valores de (xi - media)²: [%.3f]%n ", aDouble);
//        }
// System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.printf("Soma total dos valores de (x-media)²: [%.3f]%n", somaXAoQuadrado);
//        System.out.printf("Média dos valores de (x-media)²: [%.3f]%n", mediaXAoQuadrado);
//        System.out.println("-----------------------------------------------------------------------------------------------------");
//
// for (Double aDouble : subDey) {
//
//            System.out.printf("Todos os valores de de (Yi - média) : [%.3f]%n", aDouble);
//        }
// System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.printf("Soma da subtração de y com a média: [%.4f]%n", somaYzero);
//        System.out.printf("Média  da subtração de y com a média: [%.4f]%n", mediaYzero);
//        System.out.println("-----------------------------------------------------------------------------------------------------");
// for (Double aDouble : produtoSubXeY) {
//
//            System.out.printf("Todos os valores do produto de (xi-media)(yi-media): [%.3f]%n", aDouble);
//        }
// System.out.println("-----------------------------------------------------------------------------------------------------");
//        System.out.printf("Soma total do produto de (xi-media)(yi-media): [%.3f]%n", somaXY);
//        System.out.printf("Média do somatório do produto de (xi-media(yi-media): [%.3f]%n", mediaXY);
//        System.out.println("-----------------------------------------------------------------------------------------------------");
//  System.out.printf("Resultado do parâmetro B0: [%.5f]%n", parametroB0);
//        System.out.printf("Resultado do parâmetro B1: [%.5f]%n", parametroB1);


