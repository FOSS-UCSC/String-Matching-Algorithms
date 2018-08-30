//Input given as Command line argument in following structure.
// java KMP text pattern
//Developed by Hasee Amarathunga

import java.util.*;
class KMP
{
    public static void main(String args[])
    {
        String pat=args[1];
        System.out.println("Prefix Array : "+Arrays.toString(PrefixFun(pat)));
        KMPSearch(args[0],args[1]);
    }

    public static int[] PrefixFun(String pat)
    {
        int m=pat.length();
        int[] lps=new int[m];
        int i=1;
        int len=0;
        lps[0]=0;

        while(i<m)
        {
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];

                }
                else{
                    lps[i]=len;
                    i++;

                }
            }
        }
        return lps;
    }

    public static void KMPSearch(String txt,String pat)
    {
        int m=pat.length();
        int n=txt.length();
        int[] lps=PrefixFun(pat);
        int j=0;//index for pattern
        int i=0;//index for text

        while(i<n){
            if(pat.charAt(j)==txt.charAt(i))
            {
                j++;
                i++;
            }
            if(j==m){
                System.out.println("Pattern Ocuurs at index "+(i-j));
                j=lps[j-1];
            }

            else if(i<n && pat.charAt(j)!=txt.charAt(i))
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else{
                    i=i+1;
                }
            }
        }

    }

}