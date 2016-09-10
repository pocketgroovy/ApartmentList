package miyamoto.apartmentlist;


import org.junit.Test;
import static org.junit.Assert.*;

public class DescriptionSnippetsTest{

	@Test
	public void testGenerateSnippets(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets(descriptions, query);
		String expectedResult ="Premium stainless steel designer appliances; A kitchen that most chefs would drool over with easy to clean gas stove and countertops;";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets_notFound(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Distinctive accent walls and hardwood flooring; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets(descriptions, query);
		String expectedResult ="";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets_multipleSentencesWithKeyWord(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and designer walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, kitchen, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets(descriptions, query);
		String expectedResult ="Solid floors and designer walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, kitchen, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets2(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets2(descriptions, query);
		String expectedResult ="Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops;";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets2_1keyword(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets2(descriptions, query);
		String expectedResult ="Premium stainless steel designer appliances;";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets2_notFound(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets2(descriptions, query);
		String expectedResult ="";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testGenerateSnippets2_multipleSentencesWithKeyWord(){
		String descriptions = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and designer walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, kitchen, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!";
		String query = "designer kitchen";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.generateSnippets2(descriptions, query);
		String expectedResult ="Solid floors and designer walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances;";
		assertEquals(expectedResult, result);
	}

	@Test
	public void testRemoveLeadingSpace(){
		String testString = "   abscd acdc acdc";
		String expectedResult = "abscd acdc acdc";
		DescriptionSnippets description = new DescriptionSnippets();
		String result = description.removeLeadingSpaces(testString);
		assertEquals(expectedResult, result);
	}
	
}