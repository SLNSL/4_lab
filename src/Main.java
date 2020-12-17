

import java.util.ArrayList;
import java.util.List;

import classes.alive.*;
import classes.unalive.*;
import interfaces.*;
import abstracts.*;
import enums.*;
import exeptions.*;



public class Main {

    public static void main(String[] args) {
    	AddAnd combine = new AddAnd() {
			@Override
			public String characters(Someone someone, Someone onesome) {
				return someone.getName() + " и " + onesome.getName();
			}
		};

		//--------------------------------------------------------------------------------------
		Human neznayka = new Human("Незнайка");
		Action.doing(neznayka.getName(), "созданно");
		Dog mimishka = new Dog(neznayka, "Мимишка");
		Action.doing(mimishka.getName(), "созданно");
		Dog roland = new Dog(neznayka, "Роланд");
		Action.doing(roland.getName(), "созданно");
		//--------------------------------------------------------------------------------------
		System.out.println();
		//--------------------------------------------------------------------------------------
		Action.doing(neznayka.getName(),"присел");
		Action.doing(neznayka.getName(), "гладит", mimishka.getName());
		Action.doing(neznayka.getName(), "гладит", roland.getName());
		//--------------------------------------------------------------------------------------
		System.out.println();
		//--------------------------------------------------------------------------------------
		Human employee = new Human("Сотрудник конторы");
		Action.doing(employee.getName(), "созданно");
		Human hostess = new Human("Хозяйка");
		Action.doing(employee.getName(),"записал","Незнайкино имя");
		Action.doing(employee.getName(),"также","записал","имя и адрес хозяйки");
		hostess.setRealName("госпожа Минога");
		Action.doing("Имя хозяйки",", кстати - " + hostess.getRealName());
		Action.doing(employee.getName(), "сказал, что: ");
		Action.doing(neznayka.getName(),"должен уплатить фертинг, ", "за услуги конторы, или");
		Action.doing(neznayka.getName(),"должен принести это","как только получит жалованье");
		//--------------------------------------------------------------------------------------
		System.out.println();
		Event.ends("формальности");
		Action.doing(neznayka.getName(),"удаляется", "в сопровождении с " + combine.characters(roland,mimishka) + ", а также " + hostess.getRealName() + " и служанка");
		System.out.println();
		//--------------------------------------------------------------------------------------
		House house = new House(Places.HOME);
		Action.doing("Место " + house.getName(), "создано");

		House.BedRoom room = house.new BedRoom("светлая", "просторная");
		Action.doing("Комната " + room.getType(), "создано");

		room.walls.setDecor("Портреты Роланда, Мимишки и каких-то других собак");
		Action.doing(neznayka.getName(), "предстоит жить", "в доме, в комнате, с описанием: " + room.getColor() + " и " + room.getSize());
		Action.doing(room.walls.getType()," украшены предметами: " + room.walls.getDecor());
		//--------------------------------------------------------------------------------------
		System.out.println();
		//--------------------------------------------------------------------------------------
		House.BedRoom.Bed bedForRoland = room.new Bed(roland.getName(), "побольше","посреди комнаты");
		Action.doing(bedForRoland.getName(), " созданно." , " Владелец: " + bedForRoland.getOwner() + ". Размер: " + bedForRoland.getSize() + ". Позиция: " + bedForRoland.getPosition());
		House.BedRoom.Bed bedForNeznayka = room.new Bed(neznayka.getName(), "побольше","посреди комнаты");
		Action.doing(bedForNeznayka.getName(), " созданно." , " Владелец: " + bedForNeznayka.getOwner() + ". Размер: " + bedForNeznayka.getSize() + ". Позиция: " + bedForNeznayka.getPosition());
		House.BedRoom.Bed bedForMimishka = room.new Bed(mimishka.getName(), "поменьше","посреди комнаты");
		Action.doing(bedForMimishka.getName(), " созданно." , " Владелец: " + bedForMimishka.getOwner() + ". Размер: " + bedForMimishka.getSize() + ". Позиция: " + bedForMimishka.getPosition());
		//--------------------------------------------------------------------------------------
		House.BedRoom.CupBoard cupboard = room.new CupBoard("Зеркальный","у " + room.walls.getType());
		Action.doing(cupboard.getType() + " " + cupboard.getName(), " создан. Позиция: " + cupboard.getPosition());
		mimishka.setSecondName("Мими");
		cupboard.keep("собачьи фуфайки", "шубейки","попонки","жилетики","ночные пижамки","вечерние пантолончики для " + mimishka.getSecondName());
		Action.doing(cupboard.getName()," хранит вещи: " + cupboard.getThings());
		//--------------------------------------------------------------------------------------
		System.out.println();
		Event.starts("Купание");
		//--------------------------------------------------------------------------------------
		Deal bathing = new Deal("Купание собак","наиболее ответственное");
		bathing.setInfo("утреннее");
		Action.doing(neznayka.getName(),"должен выполнять", bathing.getResult() + " дело: " + bathing.getName());

		House.BathRoom bathRoom = house.new BathRoom(bathing.getName());
		Action.doing("Комната с целью:  " + bathRoom.getMission()," созданно");

		House.BathRoom.Bath bathForRoland = bathRoom.new Bath(roland.getName(),"побольше");
		Action.doing(bathForRoland.getName(), "созданно.", "Владелец: " + bathForRoland.getOwner() + ", Размер: " + bathForRoland.getSize());

		House.BathRoom.Bath bathForMimishka = bathRoom.new Bath(mimishka.getSecondName(),"поменьше");
		Action.doing(bathForMimishka.getName(), "созданно.", "Владелец: " + bathForMimishka.getOwner() + ", Размер: " + bathForMimishka.getSize());

		Deal bathingOfMimishka = new Deal("Купание", mimishka.getName(), 3);
		bathingOfMimishka.setInfo("утром, в полдень и вечером");
		Action.doing(mimishka.getName(),"должен выполнять действие " + bathingOfMimishka.getName() + " ", Integer.toString(bathingOfMimishka.getCount()) + " раза: ", bathingOfMimishka.getInfo());

		Deal bathingOfRoland = new Deal("Купание", roland.getName(), 1);
		bathingOfRoland.setInfo("по утрам");
		Action.doing(roland.getName(), "должен выполнять действие " + bathingOfRoland.getName() + " ", Integer.toString(bathingOfRoland.getCount()) + " раз:", bathingOfRoland.getInfo());

		Deal pigtails = new Deal("распутывание косичек","требует много времени");
		bathingOfRoland.setCause(pigtails);
		Action.doing(roland.getName(), "должен выполнять действие " + bathingOfRoland.getName() + " ", Integer.toString(bathingOfRoland.getCount()) + " раз ",
				"потому, что перед действием " + bathingOfRoland.getName() + " нужно выполнить \"" + bathingOfRoland.getCause().getName() + "\" которое имеет свойство: " + bathingOfRoland.getCause().getResult());

		Deal pigtailsInWater = new Deal("намокнут в воде","косы свянуться");
		roland.setView("шикарный");
		Action.doing("Если", pigtails.getName(),"не будет выполнено",", то косы ",pigtailsInWater.getName());
		Action.doing("Если", "косы",pigtailsInWater.getName(),",то",pigtailsInWater.getResult() + " и " + roland.getName() + " не будет иметь вид: " + roland.getView());
		//--------------------------------------------------------------------------------------
		Event.ends("Купание собак");
		System.out.println();
		Event.starts("Поход в парикмахерскую");
		//--------------------------------------------------------------------------------------
		Place barberShop = new Place(Places.BARBER);
		Action.doing(barberShop.getName(), "создано");

		Action.doing("После","события \"" + bathing.getInfo() + ' ' + bathing.getName() + "\",","приходится" ,"вести собак","в место: " + barberShop.getName());

		Deal plaitPigTails = new Deal("заплетают косички","востанавливается нарушенная красота");
		Deal cutTheFace = new Deal("подстригают морду и хвост","востанавливается нарушенная красота");
		Action.doing("Собаке " + roland.getName(), plaitPigTails.getName() + ", "+ cutTheFace.getName()," что способствует действию: " + cutTheFace.getResult());

		Deal greaseWool = new Deal("смазывают шерсть бриолином","шерсть красиво блестит");
		Deal blueEyes = new Deal("подкрашивают синькой глаза","глаза кажутся больше и выразительнее");
		Action.doing("Собаке " + mimishka.getName(),"подвивают щипцами кудряшки" + greaseWool.getName(),", что способствует действию: " + greaseWool.getResult());
		Action.doing("Также","Собаке " + mimishka.getName(),"подкрашивают черной краской ресницы, " + blueEyes.getName(),", что способствует действию: ",blueEyes.getResult());
		//--------------------------------------------------------------------------------------
		Event.ends("Поход в парикмахерскую");
		System.out.println();

		//--------------------------------------------------------------------------------------
		Action.doing(neznayka.getName(),"возвращается в локацию", house.getName());
		Action.doing(mimishka.getName(),"в сопровождении существа: " + neznayka.getName() + ",", "возвращается в локацию",house.getName());
		Action.doing(roland.getName(),"в сопровождении существа: " + neznayka.getName() + ",", "возвращается в локацию",house.getName());

		House.BedRoom hostessBedRoom = house.new BedRoom(hostess);
		Action.doing("Комната " + hostessBedRoom.getType(), "созданна.","Владалец: " + hostessBedRoom.getOwner().getRealName());

		House.BedRoom.Bed bedForHostess = hostessBedRoom.new Bed(hostess.getRealName());
		Action.doing(bedForHostess.getName(),"созданна. ","Владелец: " + bedForHostess.getOwner());
		Action.doing(hostess.getName(), "уже","встала с","постели");

		Action.doing(neznayka.getName(),"ведёт","собак " + combine.characters(roland,mimishka)," в комнату " + hostessBedRoom.getType() + ", владельца: " + bedForHostess.getOwner());

		Action.doing(hostess.getName(), "пожелала доброго утра","собакам: " + combine.characters(roland,mimishka));
		Action.doing(hostess.getName(),"распрашивает персонажа " + neznayka.getName(),"как они провели ночь");
		Action.doing(hostess.getName(),"отпускает завтракать", "персонажей " + neznayka.getName() + ", " + combine.characters(roland,mimishka));
		Action.doing("Отпуская,",hostess.getName(),"приказала","персонажу " + neznayka.getName(),"получше смотреть за собаками: " + combine.characters(roland,mimishka));
		//----------------3ЛАБА 3ЛАБА 3ЛАБА 3ЛАБА 3ЛАБА 3ЛАБА 3ЛАБА------------------------------------------------
		{
			Event.ends("Завтрак");
			System.out.println();
			Event.starts("Прогулка");
			//--------------------------------------------------------------------------------------
			Place dogsPark = new Place(Places.DOGSPARK);
			Action.doing("Место " + dogsPark.getName(), " созданно");
			long counfOfNannies = Math.round(Math.random() * 4 + 1);

			List<Human> nannies = new ArrayList<Human>();
			for (int i = 0; i < counfOfNannies; i++) {
				nannies.add(new Human("Няня"));
				Action.doing(nannies.get(0).getName(), "созданно");
				Dog dogOfNanny = new Dog(nannies.get(i));
				Action.doing(dogOfNanny.getName(), "созданно");
				Action.doing(nannies.get(i).getName(), " гуляет в ", dogsPark.getName());
				Action.doing(dogOfNanny.getName(), " гуляет в ", dogsPark.getName());
			}

			Action.doing(neznayka.getName(), " гуляет в ", dogsPark.getName());
			Action.doing(mimishka.getName(), " гуляет в ", dogsPark.getName());
			Action.doing(roland.getName(), " гуляет в ", dogsPark.getName());
			//--------------------------------------------------------------------------------------
			Event.ends("Прогулка");
			System.out.println();
			Event.starts("Купание");
			//--------------------------------------------------------------------------------------
			Place Home = new Place(Places.HOME);
			Action.doing("Место " + Home.getName(), " созданно");
			Action.doing(neznayka.getName(), "вторично", "купает собаку", mimishka.getName());
			Place garden = new Place(Places.GARDEN);
			Action.doing("Место " + garden.getName(), " созданно");
			Bugs grasshopper = Bugs.GRASSHOPPER;
			Bugs cricket = Bugs.CRICKET;
			Action.doing(roland.getName(),"развлекается тем, что", "ловит","в " + garden.getName()+"у жуков типа: " + cricket.getType() + " и " + grasshopper.getType());
			//--------------------------------------------------------------------------------------
			Event.ends("Купание");
			System.out.println();
			Event.starts("Обед");
			//--------------------------------------------------------------------------------------
			Place dogsRestaurant = new Place(Places.DOGSRESTAURANT);
			Action.doing("Место " + dogsRestaurant.getName(), " созданно");
			Action.doing(neznayka.getName(), " идёт обедать в ", dogsRestaurant.getName());
			Action.doing(mimishka.getName(), " идёт обедать в ", dogsRestaurant.getName());
			Action.doing(roland.getName(), " идёт обедать в ", dogsRestaurant.getName());

			//--------------------------------------------------------------------------------------
			Event.ends("Обед");
			neznayka.setEmotion("сыт");
			mimishka.setEmotion("сыт");
			roland.setEmotion("сыт");
			System.out.println(neznayka.getEmotion());
			System.out.println(mimishka.getEmotion());
			System.out.println(roland.getEmotion());
			System.out.println();
			Event.starts("Сон");
			//--------------------------------------------------------------------------------------
			Bugs flies = Bugs.FLY;
			Action.doing(mimishka.getName(), " лёг спать ", "на часика полтора");
			Action.doing(roland.getName(), " лёг спать ", "на часика полтора");

			Action.doing(neznayka.getName(), " следит чтобы их не кусали насекомые, типа: ", flies.getType());
			//--------------------------------------------------------------------------------------
			Event.ends("Сон");
			System.out.println();
			Event.starts("Прогулка");
			//--------------------------------------------------------------------------------------
			Place town = new Place(Places.TOWN);
			Action.doing("Место " + town.getName(), " созданно");
			Action.doing(neznayka.getName(), " идёт гулять в ", town.getName());
			Action.doing(mimishka.getName(), " идёт гулять в ", town.getName());
			Action.doing(roland.getName(), " идёт гулять в ", town.getName());


			DogsLove.WhatDoesHeLoves(mimishka);
			DogsLove.WhatDoesHeLoves(roland);
			//--------------------------------------------------------------------------------------
			Event.ends("Прогулка");
			System.out.println();
			Event.starts("Физ-зарядка");
			//--------------------------------------------------------------------------------------
			Human gardenWorker = new Human("Садовник");
			Action.doing(gardenWorker.getName(), "созданно");
			Action.doing(mimishka.getName(), " делают ", "физ-зарядку");
			Action.doing(roland.getName(), " делают ", "физ-зарядку");
			DogsExercise.DoExercise(mimishka);
			DogsExercise.DoExercise(roland);
			if (mimishka.getExercised()) {
				ResultOfExercises.ends(mimishka, gardenWorker);
			}
			if (roland.getExercised()) {
				ResultOfExercises.ends(roland, gardenWorker);
			}
			//--------------------------------------------------------------------------------------
			Event.ends("Физ-зарядка");
			mimishka.setEmotion("с хорошим самочувствием");
			roland.setEmotion("с хорошим самочувствием");
			System.out.println(mimishka.getEmotion());
			System.out.println(roland.getEmotion());
			System.out.println();
			Event.starts("Отдых");
			//--------------------------------------------------------------------------------------
			Thing book = new Thing("Собачий журнал");
			Action.doing("Предмет " + book.getName(), " создан");
			Action.doing(neznayka.getName(), " заполняет " + book.getName(), "");
			Action.doing(book.getName(), "обычно заполняется",
					"всеми сколько-нибудь значительными и даже не значительными случаями из жизни собак: "
							+ combine.characters(roland,mimishka));
		}
		//--------------------------------------------------------------------------------------
		Event.ends("Отдых");
		System.out.println();

		//--------------------------------------------------------------------------------------
		Action.doing("Наконец,","пора ужина","пришла","","");
		Event.ends("Ужин");
		Action.doing(neznayka.getName()+", " +hostess.getName()+", "+combine.characters(roland,mimishka),"проводят время","по разному");

		Action.doing("Если", "у персонажа " + hostess.getRealName(),"был","незванный ужин",", то " + neznayka.getName(),"приводил собак: " + combine.characters(roland,mimishka) ,"чтобы " + new Human("Гости").getName() + " могли любоваться собаками");
		Places theater = Places.THEATER;
		Action.doing("Если",hostess.getRealName(),"уходила","в " + theater.getName(),", то она обязательно ","брала с собой собаку:",mimishka.getName());
		Action.doing("Потому что в то время","была мода","таскать","по местам: " + theater.getName(),", своих комнатных собачонок");
		Places concert = Places.CONCERT;
		Action.doing("Всех","кто","являлся","в " + theater.getName() + " или " + concert.getName() + " без собаки",", тех считали неимущими бедняками и смеялись над ними");
		System.out.println();

		Action.doing("В такие вечера","на попеченье персонажа " + neznayka.getName(), "оставался","один " + roland.getName());
		Places gym = Places.SPORTDOGGYM;
		Places pool = Places.POOL;
		Places tupik = Places.TUPIK;
		Goat goat = new Goat("Козлик","Больной");
		goat.setSecondName("друг");
		Action.doing("И, " + roland.getName() + " и " + neznayka.getName(), "","отправлялись в " + gym.getName() + " или " + pool.getName(), "где смотрели какое-нибудь собачье состязание, или же отправлялись в " + tupik.getName() + " и навещали персонажа: " + goat.getHealth() + " " + goat.getName());
    	Action.doing("Нужно сказать, что",neznayka.getName(),"никогда не забывал","о персонаже: " + goat.getHealth() + " " + goat.getSecondName(),"");
		Action.doing("Не проходило дня, чтоб","он","не забежал","к нему хотя бы на минутку","");
		Action.doing("Обычно","это","удавалось сделать","во время","послеобеденной прогулки");

		Eat pie = new Eat("пирожок");
		Eat cutlet = new Eat("котлетка");
		Eat bread = new Eat("краюшка хлебца");
		goat.setHealth("Голодный");
		Action.doing("Всегда, когда",neznayka.getName(),"обедал","с собаками","он не съедал свою порцию до конца, а припрятывал в карман то " + pie.getName() + ", то " + cutlet.getName() + ", то " + bread.getName() + " и относил всё это персонажу " + goat.getHealth() + " " + goat.getName());
		//--------------------------------------------------------------------------------------
		System.out.println();
		//--------------------------------------------------------------------------------------
		Action.doing("В первый же день",neznayka.getName(),"обратился","к персонажу " + hostess.getRealName(),"с просьбой заплатить ему жалованье хотя бы за недельку вперёд");
		Action.doing("Так как","персонажу " + neznayka.getName(),"нужно помочь","больному приятелю","который находился в " + Places.TUPIKNIGHT.getName());
		Action.doing(hostess.getRealName(),"сказала, что","теперь " + neznayka.getName() + " живёт в богатом доме");
		Action.doing(neznayka.getName(),"живёт","в обществе приличных собак");
		Action.doing("Ему","не пристало","водить компанию с каким-то персонажем " + goat.getName());
		Action.doing("Ведь",goat.getName(),"не имеет","собственного дома","а обитает в какой-то локации: " + Places.TUPIKNIGHT.getName());
		//--------------------------------------------------------------------------------------
		System.out.println();
		//--------------------------------------------------------------------------------------
		Thing pay = new Thing("фертингов");
		try{
			pay.setCount("5");
		} catch(CheckedExeption e){
			e.printStackTrace();
		}

		Action.doing("Действительно,",hostess.getName(),"заплатила персонажу:",neznayka.getName() + " " + pay.getCount() + " " + pay.getName(),"как только прошла неделя");
		Action.doing("Для персонажа " + neznayka.getName(),"это","была","большая радость");
		Human doctor = new Human("Доктор");
		Action.doing("На другой день, во время послеобеденной прогулки с " + combine.characters(roland,mimishka),", " + neznayka.getName(),"зашёл","в лечебницу","и пригласил к персонажу " + goat.getName() + " персонажа " + doctor.getName());

    }
}
