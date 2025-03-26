
package csc223.lb.Assignment_1;

public class DNA {

        public static String countNucleotides(String dna){
            int nA=0;
            int nC=0;
            int nG=0;
            int nT=0;
            for (int i=0; i < dna.length(); i++){

                if (dna.charAt(i) == 'A'){
                    nA +=1;
                }else if (dna.charAt(i) == 'C'){
                    nC +=1;
                }else if (dna.charAt(i) == 'G'){
                    nG +=1;
                }else{
                    nT +=1;

                }

            }
            return nA + " " + nC + " " + nG + " " + nT;
        }
        public static String transcribe(String dna){
            String rna="";

            for (int i=0; i < dna.length(); i++){
                
                if (dna.charAt(i) == 'T'){
                    rna += 'U';
                }else{
                    rna += dna.charAt(i);
                }
            }
            return rna;

        }
        public static String reverseComplement(String dna){
            String cdna="";

            for (int i=dna.length()-1; i >= 0; i--){

                if (dna.charAt(i) == 'A'){
                    cdna +='T';
                }else if (dna.charAt(i) == 'T'){
                    cdna +='A';
                }else if (dna.charAt(i) == 'C'){
                    cdna +='G';
                }else{
                    cdna += 'C';
                }
            }
            return cdna;
        }

        public static void main(String[] args){
            String result = DNA.countNucleotides("ACCGT");
            System.out.println(result);
        }


    }


