package com.millie.amazonprice.controller;

import com.millie.amazonprice.po.CategoryPo;
import com.millie.amazonprice.service.CategoryService;
import com.millie.amazonprice.vo.EnumVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class AmazonPriceControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    AmazonPriceController amazonPriceController;

    /**
     * [DOT-C2 Standard]: 2 inch width x 150 feet length, 6" red and 6" white repeated. Full compliance with DOT-C2 standards,
     * [High Strength Adhesive]:
     * [Ultra Bright]:
     * [Good Weather Resistance]:
     * [Satisfactory After-sales Service]:
     *
     *
     *
     * [Ultra Reflective:] ➤Specializing in the production of reflective tape for over 10 years, and providing brighter and more durable reflector tape for customers. UV resistant, honeycomb pattern design dot tape and made of PET material. Highly visibler hombus patterned prisms red and white color gives ultra reflective effect. Itis mountable at any position to reflect light back from far away and from all directions.
     * [Generous Size:] ➤2 INCH Width X 164 FEET Length. High strength polymer adhesive ensures that this safety tape will last for years. This reflective tape can be stuck on any surfaces e. g. metal, wood, plastic and nylon. It is conformable to uneven surfaces so it will mold and conform better than other films.
     * [Wide Usage:] ➤DOT-C2 Approved, Alternating Red &White Pattern. The dot reflective tape it can be widely used in trailers,commercial vehicles, automobiles, ships, agricultural equipment, campers， RV's, motorcycle, cars, tricycles, trucks, helmet，raincoat, boats, Fence, Mailboxes, oreven Hiker's Backpack, Clothing etc.
     * [Weather Resistance:] ➤Weatherproof & Resists Solvents Like Kerosene, Gasoline & Diesel. It can resist various weather conditions, keep good reflection in the bad weather e. g. raining day, foggy ordark condition, won’t fade away under the sun.
     * [Durable] ➤Super bright reflects light in any situation, keep you safe during road travels. Single layer design allows for flexible application while still adhering to any surface and can withstand extreme condition.
     *
     * Size: 2"inch wide x 160ft" length,6" red and 6" white Repeated, along with an additional layer of rhombus patterned prisms ,with smooth and glossy surface that reflects light in any situation added visibility.
     * Bright Pattern: Our DOT-C2 reflective tape surface is equipped with a highly visible rhombus patterned prisms , With alternating ultra bright red , white colors and reflective sheets on ensure the reflective safety tape reflect light better in the dark, the high reflective tape gives you extra security while you driving at night.
     * Weather-Resistant: Our waterproof reflective safety sticker Resists Dirt, Grease, Rain, and Sun-fading. Excellent weather resistant and water resistant for long lasting hold even in the harshest elements. Suitable for outdoor
     * High Strength Adhesive: . Industrial Strength Adhesive, withstand extreme temperatures and will not damage in the elements, Can be sticked on any surface, metal, wood, plastic and nylon. Most people use it for walls, posts, signs ,mailboxes, power/electric poles, or any application that requires bright safety reflective tape.
     * Versatile: Approved the DOT and Exceeds Standards; reflective tape for Trailers ,Cars, Trucks, RVs, Campers, Boats, or Even Clothing.
     *
     * 200' DOT-C2 REFLECTIVE TAPE: We offer 2 rolls of 2" x 100' (total 200') Seven Sparta reflective tape. Alternates between red & white every 6 inches that meet the federal requirements for trucks. It works great for vehicles, trucks, boats, road marking, tractors, bicycles, motorcycles and mailboxes.
     * EXTRA REFLECTION AND VISIBILITY: DOT-C2 red & white reflective tape is equipped with a highly visible diamond pattern. It provides that extra visibility when needed on dark roads and catches the light from any angle. Do you want to be seen by other cars on the road? This reflective tape was just what you needed.
     * COMMERCIAL GRADE ADHESIVE & WATERPROOF: Seven Sparta reflective tape is made of waterproof PET material with commercial grade adhesive. It can resist dirt, grease, grime, rain, and sun-fading and stick excellently even in the wet cold snowy weather.
     * DOT-C2 APPROVED: Each red & white reflective strip is marked with DOT-C2, you won’t have to worry about safety and regulations, because it was approved by the dot and exceeds standards.
     * UNCONDITIONLA 30-DAY MONEY-BACK GUARANTEE: If you’re unsatisfied with this item for any reason, we’ll immediately refund your purchase price. If you have any issues need resolved after purchase, just contact us by email.
     *
     * Provide high visibility in dark area when light hits it, offer great reflective luminosity.
     * Widely use in outdoors, you can stick reflective tape on RV/trailer/camper, vehicles, postbox and outdoor building.
     * Last well and reflect light through rainy and snowy weather.
     * This tape can be stuck on many surface with it's strong adhension, such as metal, wood , nylon and plastic. Please clean the surface before stick the tape.
     * With free useful scraper, you can make the tape stick to the surface tightly.
     *
     * EXTRA STRENGTH OF STICKINESS,（please make sure the surface where you want to apply tape is dry and clean) Warning Color Red and White alternating, 6" red / 6" white reflective outdoor safety tape,Industrial Strength Adhesive,1 inch reflective tape. the longer you use our tape,the more sticky it gets into vehicle surface.EXTRA FUERZA DE LA PEGATINA.6 "rojo / 6" cinta de seguridad reflectante de color blanco(Asegúrese de que la superficie donde desea aplicar la cinta está seca y limpia)
     * 100% HIGH VISIBILITY 100% WATER PROOF 100% WASH RESISTANCE.Reflective Material amazing effect Ultra High Reflective Tape,Reflect Ultra Bright Light in All Directions! safety causion warning your perfect truck safety tape choice! 100% WEATHER PROOF and RESIST , 100% Water Proof ,Wash-Resistant,Resistant to Gasoline, Diesel and other Solvent. Outdoor reflective tape 100% ALTA VISIBILIDAD 100% RESISTENCIA A LA AGUA IMPERMEABLE A 100% Reflect Ultra Bright Light en todas las direcciones
     * HEAVY DUTY,FAIR PRICE BUT DURABLE.Color and Stickness for our caution safety tape will hold up for long time.Quality is similiar as the ones you bought at Home depot.do not waste your money on other tape with some funny price., Our tape is good enough for you to use. DISCOUNT PRICE BUT NO LACK OF QUALITY AT ALL.PRECIO JUSTO PERO DURABLE Color y Stickness para nuestra cinta se mantendrá durante mucho tiempo La calidad es similar a los que usted compró en el Depot.
     * MULTIPAL AND COMPLETE CHOICE OPTIONS FOR CONSPICUITY TAPE.ECONOMIC ROLLS.If you only want to stick on a helmut, buy the small size one like 1"x4' is good enough.TAMAÑO MÚLTIPLE CHOICE.ECONOMIC ROLLS
     * YOUR SATISFACTION IS SUPER IMPORTANT TO US.Email us or leave questions on our product page, We will be happy to asist you SATISFACCIÓN GARANTIZADA. Envíenos por correo electrónico o deje preguntas en nuestra página del producto, estaremos encantados de asist usted
     *
     * MADE OF PET HIGHLY REFLECTIVE MATERIAL, GREAT PERFORMANCE..10 times brighter than PVC reflective tape, one of the brightest reflective tapes in the market.
     * HEAVY-DUTY, VERY DURABLE, LONG SERVICE LIFE(over 3 years)resistance to extreme weather.Waterproof, Resistant to Gasoline, Diesel and other Solvent
     * VERY FLEXIBLE AND EASY TO APPLY, our self-adhesive tape will able to stick on most surfaces.Aluminum, Wood, Steel...
     * APPLICATION VARIOUS,indoor or outdoor,Perfect for helmut,trailer,truck,mailbox,bicycle,car,auto,RV,backpack...
     * YOUR SATISFACTION IS SUPER IMPORTANT TO US..FEEL FREE Email us or leave questions on our product page, We will be happy to asist you SATISFACCI¨N GARANTIZADA. Env¨ªenos por correo electr¨nico o deje preguntas en nuestra p¨gina del producto, estaremos encantados de asist usted
     *
     * Generous Size: 2" wide x 75' long roll(25 Yards),6" red and 6" white Repeated
     * Versatile: DOT-C2 Approved – You Won’t Have to Worry About Safety and Regulations Because it is Already Approved by the DOT and Exceeds Standards; Works Great for Cars, Trucks, Trailers, RVs, Campers, Boats, Mailboxes, or Even Clothing
     * Bright Pattern:reflective tape surface is equipped with a highly visible rhombus patterned prisms,high visibility red and white colors with reflective sheets on ensure the reflective safety tape reflect light better in the dark
     * WEATHER-RESISTANT: DOTC2 Diamond Grade Pattern Resists Dirt, Grease, Grime, Rain, and Sun-fading. Industrial Strength Adhesive,Great for outdoor applications on mailboxes, walls, power/electric poles, posts, signs, or any application that requires bright safety reflective tape.
     * 100% SATISFACTION GUARANTEE: If you are not completely satisfied with your our Reflective Tape, we will refund 100% of your money.
     */
    @Test
    public void testCategoryEnum() {
        CategoryPo cate1 = CategoryPo.builder().id(1L).queue(4).code("NO.4").name("第1名").build();
        CategoryPo cate2 = CategoryPo.builder().id(2L).queue(3).code("NO.3").name("第2名").build();
        CategoryPo cate3 = CategoryPo.builder().id(3L).queue(2).code("NO.2").name("第3名").build();
        CategoryPo cate4 = CategoryPo.builder().id(4L).queue(1).code("NO.1").name("第4名").build();
        List<CategoryPo> list = new ArrayList<>();
        list.add(cate1);
        list.add(cate2);
        list.add(cate3);
        list.add(cate4);
        Mockito.when(categoryService.list()).thenReturn(list);
        List<EnumVo> enumVos = amazonPriceController.categoryEnum();
        System.out.println(enumVos);
        Mockito.verify(categoryService,Mockito.times(1)).list();
    }

}