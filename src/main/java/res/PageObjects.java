package res;
/**
 *
 * @author Ark
 */

public class PageObjects {
	public static enum pageLocator { 
		sortDescending("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div/ul/li[4]"), 
		sortAscending("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div/ul/li[4]"), 
		Url("https://www.myntra.com/men-tshirts"),
		filterMenu("//*[@id='desktopSearchResults']/div[1]/section/div[1]/div[1]/div/div/div"),
		productPrice(".results-base .product-base .product-price")
		; 



		private String pageLocator; 

		private pageLocator(String pageLocator) 
		{ 
			this.pageLocator = pageLocator; 
		} 

		public String get() 
			{
				return pageLocator; 
			} 
		
	}


   

}