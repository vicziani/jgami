# JTechLog Badges

## Bevezetés

A JTechLog Badges alkalmazással az oktatók kurzusokat rögzíthetnek. A hallgatók a kurzusok elvégzése után jelvényeket
igényelhetnek. Az oktatók azt jóváhagyhatják, majd a hallgatók letölthetik.

## Indítása

Mavennel buildelhető az `mvn package` parancs kiadásával, majd a `jgami-app/jgami-app-war/target`
könyvtárban lévő jar a `java -jar jgami-app-war-0.0.1-SNAPSHOT.jar` paranccsal indítható.

Kurzust lehet felvenni a `http://localhost:8080/admin/courses` címen. Majd kérelmet lehet küldeni a
`http://localhost:8080` címen. Kérelmet jóváhagyni a `http://localhost:8080/admin/approve` címen lehet.

## Technológia

Az alkalmazás egy minta a moduláris, de monolitikus alkalmazás felépítésére. Spring Bootra épül.

A két üzleti modul a `jgami-courses`, mely a kurzusok kezelését végzi, és a `jgami-badges`, mely a jelvények kezelését.
Mindkét modul `jar` csomagolású, és van backend és frontend almodulja.

A `jgami-courses-api` modul tartalmazza a `jgami-courses` modul kiajánlott szolgáltatásainak interfészét, jelenleg ez
a `CourseInfoService`, melyen lekérdezni lehet a kurzusokat. Ezt definiálja függőségként a `jgami-badges-backend` modul.

A `jgami-core` modul definiálja azon közös részeket, melyeket minden modul használ, ez jelenleg a menükezeléshez
szükséges osztályok.

A `jgami-app-war` az összefoglaló modul, mely hivatkozik mindkét modulra, ebbe kerülnek becsomagolásra, és ez futtatható.

### Menükezelés

A `jgami-core` modulban van a `Module` interfész, melyet mind a két modul implementálja. A `jgami-app-war` modulban
van a `MenuHandlerInterceptor`, mely összegyűjti a moduloktól a menüpontokat, hiszen azok maguk definiálják, majd
elhelyezi minden kérés válaszaként visszamenő `ModelAndView` objektumban. Innen a `template.html` fájlban lévő
`menu` fragment veszi ki, melyet minden Thymeleaf template include-ál.

### I18N

Sajnos a Spring egy kontexten belül egy `MessageSource`-ot tud használni, ezért annak kell megmondani a
fordításokat tartalmazó fájlokat. Spring Boot-ban ezeket az `application.properties` fájlban kell
megadni a `spring.messages.basename` kulcs alatt. Arra is vigyázni kell, hogy a kulcsok ne
keveredjenek össze a különböző modulokban, ezért a modul nevével érdemes prefixelni a kulcsokat.


viczian.istvan a gmail-en