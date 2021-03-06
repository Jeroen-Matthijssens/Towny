package graphics;

import entity.dynamic.item.weapon.WeaponMaterial;
import entity.dynamic.item.weapon.WeaponType;

import java.util.Hashtable;
import java.util.Random;

public class SpriteHashtable {
	private static final Hashtable<Integer, Sprite> table = new Hashtable<>();
	private static final Random rand = new Random(); // random object used for random distributionof sprites


	// return random grass sprite
	public static Sprite getGrass() {
		return rand.nextBoolean() ? get(2) : get(5);
	}

	// return random stone sprite
	public static Sprite getStone() {
		return rand.nextBoolean() ? get(8) : get(9);
	}

	// return random dirt sprite
	public static Sprite getDirt() {
		return rand.nextBoolean() ? get(6) : get(7);
	}

	// returns random skin color sprite
	public static Sprite getPerson() {
		byte n = (byte) rand.nextInt(3);
		return n == 0 ? get(48) : n == 1 ? get(49) : get(50);
	}

	// return random sand sprite
	public static Sprite getSand() {
		return rand.nextBoolean() ? get(10) : get(11);
	}


	public static void registerSprite(int key, Sprite sprite) throws Exception {
		if (table.put(key, sprite) != null) {
			throw new Exception("Duplicate key while registering sprite: " + key);
		}
	}

	public static int[] maleHairNrs = new int[] {211, 213, 214, 215, 217, 218, 219, 223, 227, 228,
			229, 230, 231, 232, 233, 234, 235, 237, 238, 239, 241, 242, 243, 247, 251, 252, 253, 254,
			255, 256, 257, 258, 259, 261, 262, 263, 267, 268, 269, 270
	};

	public static Sprite[] maleHair = { get(211), get(213), get(214), get(215),
			get(217), get(218), get(219), get(223), get(227), get(228),
			get(229), get(230), get(231), get(232), get(233), get(234),
			get(235), get(237), get(238), get(239), get(241), get(242), get(243),
			get(247), get(251), get(252), get(253), get(254), get(255), get(256),
			get(257), get(258), get(259), get(261), get(262), get(263), get(267),
			get(268), get(269), get(270)
	};

	public static int[] femaleHairNrs = new int[] { 212, 216, 220, 221, 222, 224, 225, 226, 236, 240, 244, 245, 246, 248, 249, 250, 260, 264, 265, 266 };

	public static Sprite get(int key) {
		return table.get(key);
	}

	public static void registerSprites() throws Exception { //registers all sprites by id
		registerSprite(1, new Sprite(0, 0, SpritesheetHashtable.get(1))); //water
		registerSprite(2, new Sprite(5, 0, SpritesheetHashtable.get(1))); //grass
		registerSprite(4, new Sprite(0, 5, SpritesheetHashtable.get(1))); //darkGrass
		registerSprite(5, new Sprite(5, 1, SpritesheetHashtable.get(1))); //grass2
		registerSprite(6, new Sprite(6, 0, SpritesheetHashtable.get(1))); //dirt
		registerSprite(7, new Sprite(6, 1, SpritesheetHashtable.get(1))); //dirt2
		registerSprite(8, new Sprite(7, 0, SpritesheetHashtable.get(1))); //stone
		registerSprite(9, new Sprite(7, 1, SpritesheetHashtable.get(1))); //stone2
		registerSprite(10, new Sprite(8, 0, SpritesheetHashtable.get(1))); //sand
		registerSprite(11, new Sprite(8, 1, SpritesheetHashtable.get(1))); //sand2
		registerSprite(12, new Sprite(13, 11, SpritesheetHashtable.get(1))); //treebottom
		registerSprite(13, new Sprite(13, 10, SpritesheetHashtable.get(1))); //treetop
		registerSprite(14, new Sprite(27, 15, SpritesheetHashtable.get(1))); //StoneNoSides
		registerSprite(15, new Sprite(32, 13, SpritesheetHashtable.get(1)));
		registerSprite(16, new Sprite(33, 13, SpritesheetHashtable.get(1)));
		registerSprite(17, new Sprite(32, 14, SpritesheetHashtable.get(1)));
		registerSprite(18, new Sprite(33, 14, SpritesheetHashtable.get(1)));
		registerSprite(19, new Sprite(32, 15, SpritesheetHashtable.get(1)));
		registerSprite(20, new Sprite(33, 15, SpritesheetHashtable.get(1)));
		registerSprite(21, new Sprite(32, 16, SpritesheetHashtable.get(1)));
		registerSprite(22, new Sprite(33, 16, SpritesheetHashtable.get(1)));
		registerSprite(23, new Sprite(32, 17, SpritesheetHashtable.get(1)));
		registerSprite(24, new Sprite(33, 17, SpritesheetHashtable.get(1)));
		registerSprite(25, new Sprite(32, 18, SpritesheetHashtable.get(1)));
		registerSprite(26, new Sprite(33, 18, SpritesheetHashtable.get(1)));
		registerSprite(27, new Sprite(32, 19, SpritesheetHashtable.get(1)));
		registerSprite(28, new Sprite(33, 19, SpritesheetHashtable.get(1)));
		registerSprite(33, new Sprite(32, 22, SpritesheetHashtable.get(1)));
		registerSprite(34, new Sprite(33, 22, SpritesheetHashtable.get(1)));
		registerSprite(35, new Sprite(27, 18, SpritesheetHashtable.get(1)));
		registerSprite(36, new Sprite(28, 18, SpritesheetHashtable.get(1)));
		registerSprite(37, new Sprite(29, 18, SpritesheetHashtable.get(1)));
		registerSprite(38, new Sprite(30, 18, SpritesheetHashtable.get(1)));
		registerSprite(39, new Sprite(38, 10, SpritesheetHashtable.get(1)));//chest
		registerSprite(40, new Sprite(36, 18, SpritesheetHashtable.get(1))); //stairs Top
		registerSprite(41, new Sprite(34, 18, SpritesheetHashtable.get(1))); //stairs bottom
		registerSprite(42,new Sprite(3,6,SpritesheetHashtable.get(2))); //turquoise trousers long
		registerSprite(43,new Sprite(13,0,SpritesheetHashtable.get(2))); //blacksmith apron turquoise
		registerSprite(44, new Sprite(32, 1, SpritesheetHashtable.get(1))); //woodenDoorHorizontal
		registerSprite(45, new Sprite(37, 1, SpritesheetHashtable.get(1))); //woodenDoorVertical
		registerSprite(46, new Sprite(32, 2, SpritesheetHashtable.get(1)));//stoneDoorHorizontal
		registerSprite(47, new Sprite(32, 4, SpritesheetHashtable.get(1)));//stoneDoorVertical
		registerSprite(48, new Sprite(1, 0, SpritesheetHashtable.get(2)));//villager1
		registerSprite(49, new Sprite(1, 1, SpritesheetHashtable.get(2)));//villager2
		registerSprite(50, new Sprite(1, 2, SpritesheetHashtable.get(2)));//villager3
		registerSprite(51, new Sprite(0, 3, SpritesheetHashtable.get(2)));//zombie
		registerSprite(52, new Sprite(1, 3, SpritesheetHashtable.get(2)));//zombiehit
		registerSprite(53, new Sprite(0, 23, SpritesheetHashtable.get(1)));//coalOre
		registerSprite(54, new Sprite(0, 24, SpritesheetHashtable.get(1)));//ironOre
		registerSprite(55, new Sprite(0, 26, SpritesheetHashtable.get(1)));//copperOre
		registerSprite(56, new Sprite(1, 25, SpritesheetHashtable.get(1)));//goldOre
		registerSprite(57, new Sprite(0, 25, SpritesheetHashtable.get(1)));//crystalOre
		registerSprite(58, new Sprite(53, 22, SpritesheetHashtable.get(1)));//logs
		registerSprite(59, new Sprite(42, 10, SpritesheetHashtable.get(1)));//ironBar
		registerSprite(60, new Sprite(43, 10, SpritesheetHashtable.get(1)));//goldBar
		registerSprite(61, new Sprite(41, 10, SpritesheetHashtable.get(1)));//copperBar
		registerSprite(62, new Sprite(44, 10, SpritesheetHashtable.get(1)));//ironChunk
		registerSprite(63, new Sprite(45, 10, SpritesheetHashtable.get(1)));//goldChunk
		registerSprite(64, new Sprite(46, 10, SpritesheetHashtable.get(1)));//stoneChunk
		registerSprite(65, new Sprite(47, 10, SpritesheetHashtable.get(1)));//coalChunk
		registerSprite(66, new Sprite(48, 10, SpritesheetHashtable.get(1)));//copperChunk
		registerSprite(67, new Sprite(41, 24, SpritesheetHashtable.get(1)));//crystalChunkUncut
		registerSprite(68, new Sprite(41, 23, SpritesheetHashtable.get(1)));//crystalChunkCut
		registerSprite(69, new Sprite(3, 0, SpritesheetHashtable.get(2)));//blacktrousers
		registerSprite(70, new Sprite(6, 0, SpritesheetHashtable.get(2)));//brownShirt1
		registerSprite(71, new Sprite(7, 0, SpritesheetHashtable.get(2)));//brownShirt2
		registerSprite(72, new Sprite(8, 0, SpritesheetHashtable.get(2)));//brownShirt3
		registerSprite(73, new Sprite(9, 0, SpritesheetHashtable.get(2)));//brownShirt4
		registerSprite(74, new Sprite(10, 0, SpritesheetHashtable.get(2)));//greenShirt1
		registerSprite(75, new Sprite(11, 0, SpritesheetHashtable.get(2)));//greenShirt2
		registerSprite(76, new Sprite(12, 0, SpritesheetHashtable.get(2)));//greenShirt3
		registerSprite(77, new Sprite(13, 0, SpritesheetHashtable.get(2)));//greenShirt4
		registerSprite(78, new Sprite(14, 0, SpritesheetHashtable.get(2)));//greyShirt1
		registerSprite(79, new Sprite(15, 0, SpritesheetHashtable.get(2)));//greyShirt2
		registerSprite(80, new Sprite(16, 0, SpritesheetHashtable.get(2)));//greyShirt3
		registerSprite(81, new Sprite(17, 0, SpritesheetHashtable.get(2)));//greyShirt4
		registerSprite(82, new Sprite(12, 0, SpritesheetHashtable.get(1)));//furnaceOff
		registerSprite(83, new Sprite(13, 0, SpritesheetHashtable.get(1)));//furnaceOn1
		registerSprite(84, new Sprite(14, 0, SpritesheetHashtable.get(1)));//furnaceOn2
		registerSprite(85, new Sprite(15, 0, SpritesheetHashtable.get(1)));//anvil
		registerSprite(86, new Sprite(44, 4, SpritesheetHashtable.get(2)));//woodspear
		registerSprite(87, new Sprite(42, 0, SpritesheetHashtable.get(2)));//copperaxe
		registerSprite(88, new Sprite(3, 1, SpritesheetHashtable.get(2)));//browntrousers
		registerSprite(89, new Sprite(3, 5, SpritesheetHashtable.get(2)));//orangetrousers
		registerSprite(90, new Sprite(46, 0, SpritesheetHashtable.get(2)));//copperhalbert
		registerSprite(91, new Sprite(42, 5, SpritesheetHashtable.get(2)));//woodaxe
		//GAP
		registerSprite(94, new Sprite(46, 5, SpritesheetHashtable.get(2)));//woodhalbert
		registerSprite(95, new Sprite(52, 0, SpritesheetHashtable.get(2)));//woodbow
		registerSprite(96, new Sprite(49, 4, SpritesheetHashtable.get(2)));//ironspear
		registerSprite(97, new Sprite(47, 5, SpritesheetHashtable.get(2)));//ironaxe
		registerSprite(98, new Sprite(53, 1, SpritesheetHashtable.get(2)));//ironbow
		registerSprite(99, new Sprite(52, 2, SpritesheetHashtable.get(2)));//goldbow
		registerSprite(100, new Sprite(52, 4, SpritesheetHashtable.get(2)));//crystalbow
		//GAP
		registerSprite(103, new Sprite(51, 5, SpritesheetHashtable.get(2)));//ironhalbert
		registerSprite(104, new Sprite(49, 6, SpritesheetHashtable.get(2)));//goldspear
		registerSprite(105, new Sprite(47, 7, SpritesheetHashtable.get(2)));//goldaxe
		//GAP
		registerSprite(108, new Sprite(51, 7, SpritesheetHashtable.get(2)));//goldhalbert
		registerSprite(109, new Sprite(49, 8, SpritesheetHashtable.get(2)));//crystalspear
		registerSprite(110, new Sprite(47, 9, SpritesheetHashtable.get(2)));//crystalaxe
		//GAP
		registerSprite(113, new Sprite(51, 9, SpritesheetHashtable.get(2)));//crystalhalbert
		registerSprite(114, new Sprite(42, 6, SpritesheetHashtable.get(2)));//woodsword
		registerSprite(115, new Sprite(43, 6, SpritesheetHashtable.get(2)));//coppersword
		registerSprite(116, new Sprite(44, 6, SpritesheetHashtable.get(2)));//ironsword
		registerSprite(117, new Sprite(45, 6, SpritesheetHashtable.get(2)));//goldsword
		registerSprite(118, new Sprite(46, 6, SpritesheetHashtable.get(2)));//crystalsword
		registerSprite(119, new Sprite(42, 7, SpritesheetHashtable.get(2)));//wooddagger
		registerSprite(120, new Sprite(43, 7, SpritesheetHashtable.get(2)));//copperdagger
		registerSprite(121, new Sprite(44, 7, SpritesheetHashtable.get(2)));//irondagger
		registerSprite(122, new Sprite(45, 7, SpritesheetHashtable.get(2)));//golddagger
		registerSprite(123, new Sprite(46, 7, SpritesheetHashtable.get(2)));//crystaldagger
		registerSprite(124, new Sprite(42, 9, SpritesheetHashtable.get(2)));//woodscimitar
		registerSprite(125, new Sprite(43, 9, SpritesheetHashtable.get(2)));//copperscimitar
		registerSprite(126, new Sprite(44, 9, SpritesheetHashtable.get(2)));//ironscimitar
		registerSprite(127, new Sprite(45, 9, SpritesheetHashtable.get(2)));//goldscimitar
		registerSprite(128, new Sprite(46, 9, SpritesheetHashtable.get(2)));//crystalscimitar
		registerSprite(129, new Sprite(33, 1, SpritesheetHashtable.get(2)));//woodbuckler
		registerSprite(130, new Sprite(37, 1, SpritesheetHashtable.get(2)));//ironbuckler
		registerSprite(131, new Sprite(39, 0, SpritesheetHashtable.get(2)));//ironheater
		registerSprite(132, new Sprite(33, 4, SpritesheetHashtable.get(2)));//goldbuckler
		registerSprite(133, new Sprite(35, 3, SpritesheetHashtable.get(2)));//goldheater
		registerSprite(134, new Sprite(37, 4, SpritesheetHashtable.get(2)));//copperbuckler
		registerSprite(135, new Sprite(39, 3, SpritesheetHashtable.get(2)));//copperheater
		registerSprite(136, new Sprite(37, 7, SpritesheetHashtable.get(2)));//crystalbuckler
		registerSprite(137, new Sprite(39, 6, SpritesheetHashtable.get(2)));//crystalheater
		registerSprite(138, new Sprite(35, 0, SpritesheetHashtable.get(2)));//woodheater
		registerSprite(139, new Sprite(44, 1, SpritesheetHashtable.get(2)));//copperspear
		registerSprite(140, new Sprite(1, 5, SpritesheetHashtable.get(1))); //darkStone
		registerSprite(141,new Sprite(5,6,SpritesheetHashtable.get(1)));
		//GAP

		registerSprite(161, new Sprite(9, 0, SpritesheetHashtable.get(1))); //HardStoneNoSides
		registerSprite(162, new Sprite(10, 0, SpritesheetHashtable.get(1)));
		registerSprite(163, new Sprite(11, 0, SpritesheetHashtable.get(1)));
		registerSprite(164, new Sprite(10, 1, SpritesheetHashtable.get(1)));
		registerSprite(165, new Sprite(11, 1, SpritesheetHashtable.get(1)));
		registerSprite(166, new Sprite(10, 2, SpritesheetHashtable.get(1)));
		registerSprite(167, new Sprite(11, 2, SpritesheetHashtable.get(1)));
		registerSprite(168, new Sprite(10, 3, SpritesheetHashtable.get(1)));
		registerSprite(169, new Sprite(11, 3, SpritesheetHashtable.get(1)));
		registerSprite(170, new Sprite(10, 4, SpritesheetHashtable.get(1)));
		registerSprite(171, new Sprite(11, 4, SpritesheetHashtable.get(1)));
		registerSprite(172, new Sprite(10, 5, SpritesheetHashtable.get(1)));
		registerSprite(173, new Sprite(11, 5, SpritesheetHashtable.get(1)));
		registerSprite(174, new Sprite(10, 6, SpritesheetHashtable.get(1)));
		registerSprite(175, new Sprite(11, 6, SpritesheetHashtable.get(1)));
		registerSprite(176, new Sprite(10, 7, SpritesheetHashtable.get(1)));
		registerSprite(177, new Sprite(11, 7, SpritesheetHashtable.get(1)));
		registerSprite(178, new Sprite(10, 8, SpritesheetHashtable.get(1)));
		registerSprite(179, new Sprite(11, 8, SpritesheetHashtable.get(1)));
		registerSprite(180, new Sprite(10, 9, SpritesheetHashtable.get(1)));
		registerSprite(181, new Sprite(11, 9, SpritesheetHashtable.get(1)));

		registerSprite(186, new Sprite(35, 14, SpritesheetHashtable.get(1))); //WoodNoSides
		registerSprite(187, new Sprite(39, 12, SpritesheetHashtable.get(1)));
		registerSprite(188, new Sprite(40, 12, SpritesheetHashtable.get(1)));
		registerSprite(189, new Sprite(39, 13, SpritesheetHashtable.get(1)));
		registerSprite(190, new Sprite(40, 13, SpritesheetHashtable.get(1)));
		registerSprite(191, new Sprite(39, 14, SpritesheetHashtable.get(1)));
		registerSprite(192, new Sprite(40, 14, SpritesheetHashtable.get(1)));
		registerSprite(193, new Sprite(39, 15, SpritesheetHashtable.get(1)));
		registerSprite(194, new Sprite(40, 15, SpritesheetHashtable.get(1)));
		registerSprite(195, new Sprite(39, 16, SpritesheetHashtable.get(1)));
		registerSprite(196, new Sprite(40, 16, SpritesheetHashtable.get(1)));
		registerSprite(197, new Sprite(39, 17, SpritesheetHashtable.get(1)));
		registerSprite(198, new Sprite(40, 17, SpritesheetHashtable.get(1)));
		registerSprite(199, new Sprite(39, 18, SpritesheetHashtable.get(1)));
		registerSprite(200, new Sprite(40, 18, SpritesheetHashtable.get(1)));
		//GAP
		registerSprite(205, new Sprite(39, 21, SpritesheetHashtable.get(1)));
		registerSprite(206, new Sprite(40, 21, SpritesheetHashtable.get(1)));
		registerSprite(207, new Sprite(35, 17, SpritesheetHashtable.get(1)));
		registerSprite(208, new Sprite(36, 17, SpritesheetHashtable.get(1)));
		registerSprite(209, new Sprite(37, 17, SpritesheetHashtable.get(1)));
		registerSprite(210, new Sprite(38, 17, SpritesheetHashtable.get(1)));

		registerSprite(211, new Sprite(19, 0, SpritesheetHashtable.get(2))); // brownHair1
		registerSprite(212, new Sprite(20, 0, SpritesheetHashtable.get(2))); // brownHair2
		registerSprite(213, new Sprite(21, 0, SpritesheetHashtable.get(2))); // brownHairBeard1
		registerSprite(214, new Sprite(22, 0, SpritesheetHashtable.get(2))); // brownHairBeard2
		registerSprite(215, new Sprite(23, 0, SpritesheetHashtable.get(2))); // lightBrownHair1
		registerSprite(216, new Sprite(24, 0, SpritesheetHashtable.get(2))); // lightBrownHair2
		registerSprite(217, new Sprite(25, 0, SpritesheetHashtable.get(2))); // lightBrownHairBeard1
		registerSprite(218, new Sprite(26, 0, SpritesheetHashtable.get(2))); // lightBrownHairBeard2
		registerSprite(219, new Sprite(19, 1, SpritesheetHashtable.get(2))); // brownHair3
		registerSprite(220, new Sprite(20, 1, SpritesheetHashtable.get(2))); // brownHair4
		registerSprite(221, new Sprite(21, 1, SpritesheetHashtable.get(2))); // brownHair5
		registerSprite(222, new Sprite(22, 1, SpritesheetHashtable.get(2))); // brownHair6
		registerSprite(223, new Sprite(23, 1, SpritesheetHashtable.get(2))); // lightBrownHair3
		registerSprite(224, new Sprite(24, 1, SpritesheetHashtable.get(2))); // lightBrownHair4
		registerSprite(225, new Sprite(25, 1, SpritesheetHashtable.get(2))); // lightBrownHair5
		registerSprite(226, new Sprite(26, 1, SpritesheetHashtable.get(2))); // lightBrownHair6
		registerSprite(227, new Sprite(19, 2, SpritesheetHashtable.get(2))); // brownHairBeard3
		registerSprite(228, new Sprite(20, 2, SpritesheetHashtable.get(2))); // brownHair7
		registerSprite(229, new Sprite(21, 2, SpritesheetHashtable.get(2))); // brownHair8
		registerSprite(230, new Sprite(22, 2, SpritesheetHashtable.get(2))); // brownHair9
		registerSprite(231, new Sprite(23, 2, SpritesheetHashtable.get(2))); // lightBrownHairBeard3
		registerSprite(232, new Sprite(24, 2, SpritesheetHashtable.get(2))); // lightBrownHair7
		registerSprite(233, new Sprite(25, 2, SpritesheetHashtable.get(2))); // lightBrownHair8
		registerSprite(234, new Sprite(26, 2, SpritesheetHashtable.get(2))); // lightBrownHair9
		registerSprite(235, new Sprite(19, 4, SpritesheetHashtable.get(2))); // blondeHair1
		registerSprite(236, new Sprite(20, 4, SpritesheetHashtable.get(2))); // blondeHair2
		registerSprite(237, new Sprite(21, 4, SpritesheetHashtable.get(2))); // blondeHairBeard1
		registerSprite(238, new Sprite(22, 4, SpritesheetHashtable.get(2))); // blondeHairBeard2
		registerSprite(239, new Sprite(23, 4, SpritesheetHashtable.get(2))); // blackHair1
		registerSprite(240, new Sprite(24, 4, SpritesheetHashtable.get(2))); // blackHair2
		registerSprite(241, new Sprite(25, 4, SpritesheetHashtable.get(2))); // blackHairBeard1
		registerSprite(242, new Sprite(26, 4, SpritesheetHashtable.get(2))); // blackHairBeard2
		registerSprite(243, new Sprite(19, 5, SpritesheetHashtable.get(2))); // blondeHair3
		registerSprite(244, new Sprite(20, 5, SpritesheetHashtable.get(2))); // blondeHair4
		registerSprite(245, new Sprite(21, 5, SpritesheetHashtable.get(2))); // blondeHair5
		registerSprite(246, new Sprite(22, 5, SpritesheetHashtable.get(2))); // blondeHair6
		registerSprite(247, new Sprite(23, 5, SpritesheetHashtable.get(2))); // blackHair3
		registerSprite(248, new Sprite(24, 5, SpritesheetHashtable.get(2))); // blackHair4
		registerSprite(249, new Sprite(25, 5, SpritesheetHashtable.get(2))); // blackHair5
		registerSprite(250, new Sprite(26, 5, SpritesheetHashtable.get(2))); // blackHair6
		registerSprite(251, new Sprite(19, 6, SpritesheetHashtable.get(2))); // blondeHairBeard3
		registerSprite(252, new Sprite(20, 6, SpritesheetHashtable.get(2))); // blondeHair7
		registerSprite(253, new Sprite(21, 6, SpritesheetHashtable.get(2))); // blondeHair8
		registerSprite(254, new Sprite(22, 6, SpritesheetHashtable.get(2))); // blondeHair9
		registerSprite(255, new Sprite(13, 6, SpritesheetHashtable.get(2))); // blackHairBeard3
		registerSprite(256, new Sprite(24, 6, SpritesheetHashtable.get(2))); // blackHair7
		registerSprite(257, new Sprite(25, 6, SpritesheetHashtable.get(2))); // blackHair8
		registerSprite(258, new Sprite(26, 6, SpritesheetHashtable.get(2))); // blackHair9
		registerSprite(259, new Sprite(19, 8, SpritesheetHashtable.get(2))); // whiteHair1
		registerSprite(260, new Sprite(20, 8, SpritesheetHashtable.get(2))); // whiteHair2
		registerSprite(261, new Sprite(21, 8, SpritesheetHashtable.get(2))); // whiteHairBeard1
		registerSprite(262, new Sprite(22, 8, SpritesheetHashtable.get(2))); // whiteHairBeard2
		registerSprite(263, new Sprite(19, 9, SpritesheetHashtable.get(2))); // whiteHair3
		registerSprite(264, new Sprite(20, 9, SpritesheetHashtable.get(2))); // whiteHair4
		registerSprite(265, new Sprite(21, 9, SpritesheetHashtable.get(2))); // whiteHair5
		registerSprite(266, new Sprite(22, 9, SpritesheetHashtable.get(2))); // whiteHair6
		registerSprite(267, new Sprite(19, 10, SpritesheetHashtable.get(2))); // whiteHairBeard3
		registerSprite(268, new Sprite(20, 10, SpritesheetHashtable.get(2))); // whiteHair7
		registerSprite(269, new Sprite(21, 10, SpritesheetHashtable.get(2))); // whiteHair8
		registerSprite(270, new Sprite(22, 10, SpritesheetHashtable.get(2))); // whiteHair9

	}
}
