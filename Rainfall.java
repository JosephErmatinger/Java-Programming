/*
 * Program Name: YourChoice2.java
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-14
 */

public class Rainfall 
{
	double[] rainfallStats;
	
	//--------getTotalRainfall-----------------------
	//iterates through the array, assigning rainfall amounts from each month to
	//totalRainfall and returns
	public double getTotalRainfall() 
	{
		double totalRainfall = 0;
		for ( int i = 0; i < rainfallStats.length; i++ ) 
		{
			totalRainfall += rainfallStats [i];	
		}
		return totalRainfall;
	}
	
	//---------getAverageRainfall-----------------
	//iterates through the array, and divides totalRainfall by count and returns
	public double getAverageRainfall() 
	{
		double totalRainfall = 0;
		int count = 0;
		
		for ( int i = 0; i < rainfallStats.length; i++ ) 
		{
			totalRainfall += rainfallStats [i];
			count +=1;
		} 
		
		return totalRainfall /= count;
	} 
	
	//---------getMostRain-------------------------------
	// iterates through array, setting mostRainMonth to be one more than the index
	// at which the the value is the greatest
	public int getMostRain() 
	{
		double mostRain = rainfallStats[0];
		int mostRainMonth = 0;
		
		for ( int i = 0; i < rainfallStats.length; i++ ) 
		{
			
			
			if (rainfallStats[i] >= mostRain) 
			{
				mostRain = rainfallStats[i];
			    mostRainMonth = i + 1;
			}
		}	
		return mostRainMonth;
	}
	
	//---------getLeastRain--------------------------------
	//iterates through array, setting leastRainMonth to be one larger than the index 
	//at which the value is the least
	public int getLeastRain() 
	{
		double leastRain = rainfallStats[0];
		int leastRainMonth = 0;
		
		for ( int i = 0; i < rainfallStats.length; i++ ) 
		{
			if (rainfallStats[i] <= leastRain) 
			{
				leastRain = rainfallStats[i];
			    leastRainMonth = i + 1;
			}
		}	
		return leastRainMonth;
	}
		
	//-------Rainfall Constructor: receives a double array---------
	public Rainfall(double[] precipStatRcv) 
	{
		rainfallStats = new double [precipStatRcv.length ];
		
		for ( int i = 0; i < precipStatRcv.length; i++ )
			rainfallStats [i] = precipStatRcv[i];
	}
}