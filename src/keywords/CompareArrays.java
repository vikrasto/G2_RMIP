package keywords;

public class CompareArrays {
	public static void compareStringArrays(String[] array1, String[] array2) 
	{
        Assertions.verifyIfIntValuesAreEqual(array1.length, array2.length);
        for (int i = 0; i < array2.length; i++) 
              {
                 Assertions.verifyStringValuesAreEqual(array2[i], array1[i]);      	
              }
    }
}
