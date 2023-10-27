# Spring Boot 3

# Spring Boot ?

Spring Boot 是目前流行的微服務框架，倡導 **約定優先於配置**，其設計的目的是用來簡化 Spring 應用的初始化搭建以及開發過程。Spring Boot 提供了很多核心的功能，比如：自動化配置 starter (啟動器) 簡化 Maven 配置、內嵌 Servlet 容器、應用監控等功能，讓我們可以快速構建企業級應用程序。

特性：

- 創建獨立的 Spring 應用程序
- 嵌入式 Tomcat、Jetty、Undertow 容器 (jar)
- 提供的 starters 簡化構建配置 (簡化依賴管理和版本控制)
- 盡可能自動配置 spring 應用和第三方框架
- 提供生產指標，例如：指標、健康檢查和外部化配置
- 沒有代碼生成，無須 XML 配置

Spring Boot 同時提供***開箱即用***、***約定優於配置*** 的特性。

***開箱即用***：Spring Boot 應用程式可以直接使用框架模板「Spring Initializr」創建項目，基礎配置已經完成，並且集成了大部分的第三方庫對象，無需進行配置就可以使用。例如，在 Spring Boot 項目中使用 MyBatis，可以直接使用 XXXMapper 對象，調用方法執行 SQL 語句。

***約定優於配置***：Spring Boot 定義了常用類、包的位置和結構，並且預設了這些位置。因此，即使不對代碼進行調整，項目也能夠按照預期運行。例如，在 root 包的路徑下啟動類使用了 @SpringBootApplication 註解，並且創建了默認的測試類。Controller、Service、Dao 應該放在 root 包的子包中。此外，application 為默認的配置文件。

- 腳手架 (spring 提供的一個 web 應用，幫助開發人員創建springboot項目)
- SpringBoot 3 最小 jdk17，支持 17-20

Spring Boot 理念 約定優於配置，也可以稱為約定編程

腳手架是一個程式開發工具，通常用來快速創建一個基本的應用程式骨架，讓開發者可以專注於開發核心功，腳手架也被稱為「樣板程式」或「範本程式」。

腳手架通常會包含一些預設的應用程式結構、配置、檔案和資料庫連接等，讓開發人員可以快速開始開發。Spring Boot是一個流行的Java框架，提供了一個腳手架稱為「Spring Initializr」，可以幫助開發人員創建Spring Boot項目。

在Spring Boot中，腳手架則被稱為「initializer」或「generator」。

### 與 Spring 關係

Spring Boot 創建的是 Spring 應用，對於這點非常重要，也就是使用 Spring 框架創建的應用程序，這裡的 Spring 指的是 Spring Framework。我們常說的 Spring ，指的 Spring 家族，包括 Spring Boot、Spring Framework、Spring Data、Spring Security、Spring Batch、Spring Shell、Spring for Apache Kafka…。

Spring 的核心功能： IoC、AOP、事務管理、JDBC、SpringMVC，Spring WebFlux，集成第三方框架 MyBatis、Hibernate、Kafka、消息對列…

Spring 包含 SpringMVC，SpringMVC 作為 web 開發的強有力框架，是 Spring 中的一個模塊。

首先明確一點，Spring Boot 和 Spring Framework 都是創建 Spring 的應用程序。Spring Boot 是一個新的框架，看做是 Spring 框架的擴展，它消除了設置 Spring 應用程序所需要的 XML 配置，更快速更高效的創建 Spring 應用。Spring Boot 能夠快速創建基於 Spring 、Spring MVC 的普通應用以及 Web 項目

### 與 Spring Cloud 關係

「微服務 (Microservices Architecture)」是一種架構和組織方法，指的是將一個大型的應用程式拆分成多個小型的、獨立的、有業務功能的服務。每個服務都有自己的處理和輕量通訊機制，可以部署在單個或多個伺服器上。

將一個大型應用程式的功能依據業務功能類型，抽象出相對獨立的功能，稱為服務。每個服務就是一個應用程式，有自己的業務功能。透過輕量級的通訊機制 (通常是基於 HTTP 的 RESTful API) 與其他服務通訊，協調其他服務完成業務請求的處理。這樣的服務是獨立的，與其他服務是隔離的，可以獨立部署、運行，並且與其他伺服器解耦合。

微服務可以看作是模塊化的應用程式，將一個大型應用程式分成多個獨立的服務，透過 HTTP 或 RPC 將多個部分聯繫起來，請求沿著一定的請求路徑完成服務處理。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8ad6f178-ed9e-4649-98a7-e840aaf43519/Untitled.png)

當項目規模龐大、服務眾多時，構建穩定、高效、不間斷地提供服務的分布式應用程式是一個挑戰。為此，Spring Cloud 提供了有力的支持。

Spring Cloud 是一系列框架的有序組合，為開發人員提供了快速構建分布式系統所需的常用工具，包括配置管理（Configuration Management）、服務發現（Service Discovery）、斷路器（Circuit Breaker）、智能路由（Intelligent Routing）、微代理（Micro-proxy）、控制總線（Control Bus）、一次性令牌（Token）、全局鎖（Global Lock）、領導選舉（Leadership Election）、分布式會話（Distributed Session）和集群狀態（Cluster State）等。使用 Spring Cloud，開發人員可以快速建立實現分布式服務所需的框架和工具集合。這些框架需要使用 Spring Boot 作為基礎開發平台。

要創建良好的 Spring Cloud 應用程式，實現分步式應用程式，需要先學好 Spring Boot，然後使用 Spring Cloud 的框架和工具。

---

### 最新的  Spring Boot 3 新特性

在2022年11月24日，Spring Boot 3發佈，這是一個重大的里程碑發布。Spring官方網站將支持Spring Boot 3.0.X版本直到2025年。

Spring Boot 3的重大變化如下：

1. JDK最小版本為Java 17，能夠支持17至20版本。
2. Spring Boot 3.0已將所有底層依賴從Java EE遷移到Jakarta EE API。原本以javax開頭的包名已被修改為jakarta。例如：javax.servlet.http.HttpServlet → jakarta.servlet.http.HttpServlet。
3. 支持GraalVM原生映像，將Java應用程序編譯為本機代碼，提供顯著的內存和啟動性能改進。
4. 更新了第三方庫的版本支持。
5. 修改了自動配置文件。
6. 提供新的聲明式HTTP服務，通過在接口方法上聲明`@HttpExchange`來獲取遠程http訪問的能力。代替了OpenFeign。
7. Spring HTTP客戶端提供了基於Micrometer的可觀察性，可以跟蹤服務並記錄服務運行狀態等。
8. 支持AOT（Ahead Of Time）預先編譯，即在運行前進行編譯。
9. Servlet 6.0規範。
10. 支持Jackson 2.14。
11. Spring MVC：默認情況下使用PathPatternParser，刪除了過時的文件和Freemarker、JSP支持。

隨著Spring Boot 3的發布，還有Spring Framework 6.0的發布（2022年11月16日），早於Spring Boot的發布。

## 腳手架

腳手架是一個程式開發工具，通常用來快速創建一個基本的應用程式骨架，讓開發者可以專注於開發核心功，腳手架也被稱為「樣板程式」或「範本程式」。

腳手架通常會包含一些預設的應用程式結構、配置、檔案和資料庫連接等，讓開發人員可以快速開始開發。Spring Initializr是創建 Spring Boot 項目的腳手架，可以幫助開發人員創建 Spring Boot 項目。它是一個 web 應用，能夠在瀏覽器中使用。IDEA 中繼承了此工具，用來快速創建 Spring Boot 項目以及 Spring Cloud 項目。

Spring Initializr 腳手架的 web 網址：[https://start.spring.io/](https://start.spring.io/)

## 代碼結構

### 單一模塊

一個工程一個模塊的完整功能實現。創建學生模塊功能的 Spring Boot 項目 Lesson4

com.example.模塊名稱

```
+----Application.java 啟動類
+----controller 控制器包
				---StudentController.java
				---ScoreController.java
+----service 業務層包
				---inter 業務層interface
				---impl interface實現包
+----repository 持久層包
+----model 模型包
				---entity 實體類包
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/81c6850b-27a5-4235-9ef8-d14c664eb2f8/Untitled.png)

### 多個模塊

一個 Spring Boot 中多個模塊。在 root 包下創建每個模塊的子包，子包中可以按「單一模塊」包結構定義。創建包含多個功能的單體 Spring Boot。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8f8306aa-5ce0-4d83-ab1b-713699d38549/Untitled.png)

### 包和主類

- 建議將主應用程序類定位在其他類之上的root包中。
- `@SpringBootApplication`通常放在主類上，它隱式地為某些項定義了一個基本的「搜索包」。
- 例如，如果正在編寫一個JPA應用程序，則使用`@SpringBootApplication`類的包來搜索@Entity項。
- 使用root包還允許組件掃描只應用於此項目。
- Spring Boot基於Java的配置。儘管可以將SpringApplication與XML源一起使用，但通常建議主源是單個@Configuration類。
- 通常定義主方法的類可以做為主`@Configuration`類。

補充說明：

- root包通常是指應用程序的最上層包，它包含了所有其他包和類。
- `@SpringBootApplication`是Spring Boot中最常用的注解之一，它結合了`@Configuration`、`@EnableAutoConfiguration`和`@ComponentScan`三個注解的功能。
- `@Entity`是JPA中的注解之一，用於聲明一個Java類是一個JPA實體。
- `@Configuration`是Spring框架中的注解之一，用於聲明一個類是Spring應用程序上下文中的配置類。
- `@ComponentScan`是Spring框架中的注解之一，用於告訴Spring在哪些包中搜索組件，並自動將它們注入到應用程序上下文中。

Spring Boot 基於 java 的配置。盡管可以將 SpringApplication 與 XML 源一起使用，但通常建議主源是單個 @Configuration類。通常定義主方法的類可以做為主 @Configuration 類。

### spring-boot-starter-parent

pom.xml 中的 <parent> 指定 spring-boot-starter-parent 作為座標，表式繼承 Spring Boot 提供的父項目。從 spring-boot-starter-parent 繼承以獲得合理的默認值和完整的依賴樹，以便快速建立一個 Spring Boot 項目。父項目提供以下功能：

- JDK 的基準版本，比如 <java.version>17</java.version>
- 源碼使用 UTF-8 格式編碼
- 公共依賴的版本
- 自動化的資源過濾：默認把 src/main/resources 目錄下的文件進行資源打包
- maven 的占位符為 @
- 對多個 Maven 插件做了默認配置，如 maven-compile-plugin、maven-jar-plugin

## starter

`starter`是一組依賴描述，可以獲取Spring相關技術的一站式依賴和版本。應用中包含`starter`，可以快速啟動並運行項目，而不必複製、貼上代碼。

- `starter`包含了以下內容：
    - 依賴座標和版本：指定了需要使用的Spring相關技術的庫的座標和版本號。
    - 傳遞依賴的座標和版本：指定了需要使用的Spring相關技術所依賴的其他庫的座標和版本號。
    - 配置類和配置項：指定了需要自動配置的類和配置項，以便在啟動應用程序時自動配置Spring相關技術。
- `starter`是Spring Boot中的一個重要概念，它使得開發人員可以更加輕鬆地使用Spring相關技術，並且無需手動配置所有必要的庫和配置。
- Spring Boot提供了許多不同的`starter`，每個`starter`都專門用於支持特定的Spring相關技術，例如`spring-boot-starter-web`用於支持Web應用程序開發，`spring-boot-starter-data-jpa`用於支持JPA數據訪問。
- 在使用`starter`時，只需要在pom.xml文件中引入相應的`starter`依賴即可，Spring Boot會自動進行所有必要的配置和

## 核心註解

### @SpringBootApplication

- 核心註解功能

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/48726bb2-ca48-42e4-a753-a101d1eb75af/Untitled.png)

- @SpringBootApplication：包含@Configuration註解的功能

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8efbcb11-6052-4285-a421-425d4c917723/Untitled.png)

- @Configuration：JavaConfig的功能，配置類，結合@Bean能夠將object注入到spring的IOC容器
- 有@SpringBootApplication標註的類是配置類，Application是配置類

### @SpringBootConfiguration

```java
@Configuration
@Indexed
public @interface SpringBootConfiguration {
    @AliasFor(
        annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}
```

使用了`@SpringBootConfiguration`標注的class，可以做為配置文件使用的，可以使用Bean聲明object，注入到容器

### @EnableAutoConfiguration

開啟自動配置，將spring和其第三方庫中的object創建好，注入到spring容器 避免寫xml，去掉樣例代碼，需要使用的object，由框架提供

### @ComponentScan

- 組件掃描器，<context:component-scan base-package="xxx包"/>
- 掃描@Controller，@Service，@Repository，@Component註解，創建他們的object注入到容器
- 默認掃描的package：`@ComponentScan`所在的class和所在的package和子package

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/684fe489-3ec8-4eaa-b4f4-b338026b6df0/Untitled.png)

## 運行 Spring Boot 項目方式

- 開發工具，例如 IDEA 執行 main 方法
- Maven 插件 mvn spring-boot:run
- java -jar xxx.jar

Spring Boot 項目可以打包為 jar 或者 war 文件。因為 Spring Boot 內嵌了 web 服務器，例如：tomcat，能夠以 jar 方式運行 web 應用。無須安裝 tomcat 程序。

### 進階

普通的 jar 與 Spring Boot的jar 區別

| 項目 | Spring Boot jar                                                                               | 普通的jar                            |
| --- |-----------------------------------------------------------------------------------------------|-----------------------------------|
| 目錄 | BOOT-INF：應用的 class 和依賴的jar <br/>META-INF：清單 <br/>org.springframework.boot.loader：spring-boot-loader 模塊類 | META-INF：清單 <br/>class 的文件類： jar 中的所有類 |
| BOOT-INF | class：應用的類 lib：應用的依賴 | x                                                                                             |
| spring-boot-loader | 執行 jar 的 Spring Boot 類                                                                        | x                                 |
| 可執行 | 能                                                                                             | 否                                 |

## 外部化配置

應用程序 = 代碼 + 數據 (數據庫，文件，url)

應用程序由代碼和數據（例如數據庫、文件和URL）組成。為了在不同的環境中使用相同的應用程序代碼，避免硬編碼並提高系統的靈活性，Spring Boot 提供了一種配置機制。該機制允許在代碼之外提供應用程序運行所需的數據。Spring Boot 可以使用各種外部配置源，包括 Java 屬性文件、YAML 文件、環境變量和命令行參數。

在項目中，通常會使用 properties 和 yaml 文件作為配置源，其次是命令行參數。properties 文件使用基於鍵值對的格式，而 yaml 文件使用基於縮進的層次結構格式。這些文件中可以配置各種應用程序屬性，例如數據庫連接信息、服務器端口號等。命令行參數也可以用來覆蓋配置文件中的屬性值，從而實現更靈活的配置。

### 配置文件格式

配置文件有兩種格式

- properties：是 Java 中常用的一種配置文件格式，key=value，key是唯一的，文件擴展名為properties。
- yaml (yml)：(YAML Ain’t Markup Language) 也看做是 yml，是一種作配置文件的數據格式，基本的語法 key: value。yml 文件擴展名是 yaml 或 **yml(常用)**

yml 格式特點：

- 大小寫敏感
- 使用縮進式表示層級關係
- 縮進只可以使用空格，不允許使用 Tab 鍵
- 縮進的空格數目不重要，相同層級的元素左側對齊即可
- `#` 字符表示注釋，只支持單行注釋。

YAML 縮進必須使用空格，而且區分大小寫，建議編寫 YAML 文件只用小寫和空格。

YAML 支持三種數據結構

- 對象：key-value 的集合，又稱為映射(mapping) / 哈希 (hashes) / 字典 (dictionary)
- 數組：一組按次序排列的值，又稱為序列(sequence) / 列表(list)
- 標量：scalar，單個的、不可再分的值，例如數字、字符串、true | false 等

可至 [yaml官網](https://yaml.org/type/index.html) 獲取詳細介紹

### application 文件

Spring Boot 支持使用 properties 和 yml 格式的配置文件，預設的配置文件名稱為 application，也可以使用 application.properties 或 application.yml 來指定，默認優先加載properties ，推薦只使用一種格式。

在 Spring Boot 中，可以使用 `@Value`註解將配置文件中的參數值注入到 Bean 的屬性中。如果需要一次注入多個 key 值到 Bean 的多個屬性中，可以使用 `@ConfigurationProperties` 註解。此外，Spring Boot 還提供了一個抽象對象 Environment，它包含了幾乎所有外部配置文件、環境變量、命令行參數等的所有 key 和 value。如果需要在代碼中訪問配置文件中的屬性，可以使用 `Environment` 對象，調用它的 `getProperty(String key)` 方法即可。需要注意的是，在使用 `@Value`
註解注入配置文件中的值時，需要在配置文件中使用 `${}` 或 `#{}` 包括 key 值。

### Environment

Environment 是外部化抽象對象，是多種資料來源的集合，從中可讀取application 配置文件、環境變量、系統屬性。

在 Spring Boot 中，可以使用 `@Autowired` 或 `@Resource` 註解將 `Environment` 對象注入到 Bean 中。需要注意的是，在使用 `Environment` 對象讀取配置文件中的屬性值時，需要使用`getProperty()` 方法指定 key 值，並且可以通過 `getProperty()` 方法的第二個參數指定默認值，以防該 key 值不存在時返回 null。

除了 `getProperty()` 方法，`Environment` 還提供了其他一些有用的方法，例如 `getActiveProfiles()` 可以獲取當前激活的 profile，`getRequiredProperty()` 可以獲取必需的屬性值，如果該屬性不存在則會拋出異常。

```java
@Autowired
private Environment environment;
public void print() {
    // 獲取某個 key 的值
    String name = environment.getProperty("app.name");
    // 判斷 key 是否存在
    if (environment.containsProperty("app.owner")) {
        System.out.println("app.owner是存在的");
    }
    // 讀取 key 的值，轉為期望的類型，同時提供默認值
    Integer port = environment.getProperty("app.port", Integer.class, 9001);
    String str = String.format("讀取的key值, name = %s, port = %d", name, port);
    System.out.println("str = " + str);
}
```

### 組織多文件

大型集成的第三方框架，中間件比較多，每個框架的配置細節相對複雜，如果都將配置集中到一個 application 文件，導致文件內容多，不易閱讀，我們將每個框架獨立一個配置文件，最後將多個文件集中到 applicaiton。使用導入文件的功能

可以將配置文件進行分類，使得每個框架的配置細節更加清晰，同時也方便了文件的維護和管理。在 Spring Boot 中，可以使用 `@PropertySource` 註解來導入外部的配置文件，這樣就可以將多個配置文件集中到一個 application 文件中。需要注意的是，如果導入的配置文件名稱和預設的配置文件名稱相同，則導入的配置文件會覆蓋預設的配置文件。另外，如果需要在多個配置文件中使用相同的 key 值，可以使用 `@ConfigurationProperties`
註解來進行配置。這樣就可以將相同 key 值的配置集中到一個類中，方便管理和維護。最後，通過在 application 文件中引用多個配置文件，可以實現多個框架的配置集中管理，使得應用程序的配置更加清晰易讀。

範例：

1. 在 resources 創建自定義 conf 目錄，在 conf 中創建 redis.yml、db.yml

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/05efc2e1-be5b-485c-85b4-cf65e2a772ec/Untitled.png)

1. application.yml 導入多個配置

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1e45d8d8-6ffa-4134-8a6f-dc45134369be/Untitled.png)

### 多環境配置

在軟件開發中，環境是一個重要的概念，它涉及到許多方面，例如應用訪問資料庫的ip、用戶名和密碼，Redis的端口，配置文件的路徑，操作系統等等。這些因素會影響軟件的運行。為了隔離應用程序配置並使其僅在特定環境中使用，Spring Boot 提供了 Spring Profiles。常見的環境有開發、測試和生產等。每個環境都有一組相關的配置數據，這些配置數據支撐著應用在這些環境下運行。在應用啟動時，指定適合的環境能夠方便解決不同環境下的問題。

Spring Boot 規定環境文件的名稱應該為 application-{profile}.yml(properties)，其中 profile 為自定義的環境名稱。推薦使用 dev 表示開發，test 表示測試，prod表示生產，feature 表示特性等。profile 名稱是自定義的。Spring Boot 會加載 application 以及 application-{profile} 兩類文件，不只是單獨加載 application-{profile}。這樣做的好處是，當應用程序在不同的環境中運行時，能夠輕鬆地切換配置文件，而不需要修改代碼。這使得開發人員能夠更加輕鬆地為不同的環境進行配置。

Spring Boot 支持使用 @Profile 注解來標記類或方法，以便在特定環境下啟用或禁用它們。此外，Spring Boot 還支持使用 Spring Cloud Config 來集中管理多個應用程序的配置。這意味著可以將所有應用程序的配置儲存在一個中央位置，並在需要時將其提供給應用程序。最後，Spring Boot 還支持使用外部配置源，例如環境變數和命令行參數，來設置應用程序的配置。這些選項使得 Spring Boot 可以更加靈活地適應各種不同的場景和需求。

範例：

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/655861ab-48e0-407a-8388-78287316e3ef/Untitled.png)

### 綁定 Bean

在Spring Boot中，可以使用@ConfigurationProperties來綁定Bean的屬性，從而實現強類型的Bean。這樣Bean就可以訪問到配置數據，並且能夠進行驗證基本格式。

如果屬性較多時，使用@Value綁定單個屬性可能不太方便，因此Spring Boot提供了另一種更方便的方法，即將多個配置項綁定到Bean的屬性上。這樣一來，Bean就能夠訪問到配置數據，同時也提供了對框架的定制參數。

在Spring Boot自動配置中，大量使用了綁定Bean與@ConfigurationProperties來實現對框架的定制參數。如果項目中要使用的數據是可變的，推薦在yml或properties中提供，以提高項目代碼的靈活性。

@ConfigurationProperties不僅能夠配置多個簡單類型屬性，還支持Map、List、數組等類型。此外，它還能夠驗證基本格式，從而保證配置數據的正確性。需要注意的是，Bean的static屬性不支持@ConfigurationProperties。

範例：

- 創建 application.yml

```yaml
# 編寫配置項 key: 值
app:
  name: Lesson07
  owner: Lin
  port: 8081
```

- 創建Bean

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties：表示使用Bean對象讀取配置項 prefix: 表示配置文件中多個key的公共開始部分
 * 比如：app.name、app.port...，這裡的app就是prefix
 */
// @Component
// 創建普通bean，非spring代理
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app")
public class AppBean {

    // key的名稱與屬性名稱相同，調用屬性setXXX方法給屬性賦值
    private String name;
    private String owner;
    private String port;
		// getter and setter and toString
}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f380bb42-bf2b-4c91-8886-8f5fb1f28131/Untitled.png)

### 嵌套 Bean

Bean 中包含其他 Bean 作為屬性，將配置文件中的配置項綁定到 Bean 以及引用類型的成員。Bean 的定義無特殊要求。

範例：

- application.yml

```yaml
# 編寫配置項 key: 值
app:
  name: Lesson07
  owner: Lin
  port: 8081
  security:
    username: root
    password: 1234
```

- 定義兩個Bean

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app")
public class NestAppBean {
    private String name;
    private String owner;
    private String port;
    private Security security;
		 // getter and setter and toString
}
```

```java
public class Security {
    private String username;
    private String password;
		// getter and setter and toString
}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f4621f6e-ea73-4dad-9de5-2e7591fd2404/Untitled.png)

### 掃描注解

`@ConfigurationProperties` 注解是用來綁定Bean的屬性，但是要讓它起作用，需要使用 `@EnableConfigurationProperties` 或 `@ConfigurationPropertiesScan` 注解。這兩個注解的作用是尋找帶有 `@ConfigurationProperties` 注解的Bean，並將其注入到Spring容器中。

`@EnableConfigurationProperties` 注解可以在啟動類上使用，用來啟用 `@ConfigurationProperties` 注解，從而實現Bean的綁定。如果在啟動類上使用了 `@EnableConfigurationProperties` 注解，那麼Spring Boot會自動掃描專案中帶有 `@ConfigurationProperties` 注解的Bean，並將其注入到Spring容器中。

另外，`@ConfigurationPropertiesScan` 注解也可以用來掃描帶有 `@ConfigurationProperties` 注解的Bean，但是它需要顯式地指定要掃描的包名或類名。這個注解可以在任何Spring管理的Bean上使用，通常是在啟動類上使用。

總之，使用掃描注解可以讓Spring Boot自動掃描並注入帶有 `@ConfigurationProperties` 注解的Bean，從而實現配置文件與Java Bean的映射關係。這樣一來，就可以方便地管理和訪問配置數據。

範例：

- @EnableConfigurationProperties

```java
// 啟用ConfigurationProperties，屬性是類的名字
@EnableConfigurationProperties(NestAppBean.class)
@SpringBootApplication
public class Lesson7ConfigureApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson7ConfigureApplication.class, args);
	}

}
```

- @ConfigurationPropertiesScan

```java
// 掃描注解的package，其中綁定Bean注入到Spring容器
@ConfigurationPropertiesScan(basePackages = "com.example.configure.pk6")
@SpringBootApplication
public class Lesson7ConfigureApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson7ConfigureApplication.class, args);
	}

}
```

### 處理第三方庫對象

當需要在配置文件中提供第三方庫對象的數據時，可以使用`@ConfigurationProperties`注解結合`@Bean`注解在方法上面使用。這樣一來，就可以將第三方庫對象注入到Spring容器中，並且可以使用配置文件中的數據進行初始化。

具體而言，需要在方法上面添加`@Bean`注解，並且指定該方法返回的對象類型。同時，在該方法上面添加`@ConfigurationProperties`注解，並指定該注解的prefix屬性，用來指定配置文件中的前綴。這樣一來，Spring Boot就會自動將配置文件中的數據注入到對象中。

例如，假設需要將RedisTemplate對象注入到Spring容器中，可以按照以下方式進行配置：

```java
@Configuration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // ...
        return redisTemplate;
    }
}
```

在上面的例子中，`@Bean`注解用來指定返回的對象類型為RedisTemplate<String, Object>，而`@ConfigurationProperties`注解則用來指定配置文件中的前綴為"spring.redis"。這樣一來，Spring Boot就會自動將配置文件中以"spring.redis"為前綴的數據注入到RedisTemplate對象中。

範例：現在有一個Security類是第三方庫中的類，現在要提供它的username、password屬性值

- application.yml

```yaml
security:
  username: 12345
  password: 안녕하세요
```

- 建立Configuration類

```java
@Configuration
public class ApplicationConfig {

    // 創建bean對象，屬性值來自配置文件
    @ConfigurationProperties(prefix = "security")
    @Bean
    public Security createSecurity() {
        return new Security();
    }
}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/09a308c4-df4a-4673-85d9-2d99a3a9f8d9/Untitled.png)

### 綁定Map-List-Array

`@ConfigurationProperties` 注解不僅能夠綁定單個屬性，還能夠綁定Map、List和Array等類型的數據。這樣一來，就可以方便地管理和訪問複雜的配置數據。

綁定Map類型的數據可以使用Java的Map類型或者Properties類型來表示。需要在Bean中定義一個Map類型的屬性，並使用`@ConfigurationProperties`注解指定該屬性對應的前綴。例如：

```java
@Component
@ConfigurationProperties(prefix = "my.map")
public class MyConfig {

    private Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

```

在上面的例子中，`@ConfigurationProperties`注解指定了前綴為"my.map"，而MyConfig類中定義了一個Map<String, String>類型的屬性map，用來存儲配置文件中以"my.map"為前綴的數據。這樣一來，就可以方便地訪問配置文件中的Map類型數據了。

綁定List或Array類型的數據可以使用Java的List或Array類型來表示。需要在Bean中定義一個List或Array類型的屬性，並使用`@ConfigurationProperties`注解指定該屬性對應的前綴。例如：

```java
@Component
@ConfigurationProperties(prefix = "my.list")
public class MyConfig {

    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}

```

在上面的例子中，`@ConfigurationProperties`注解指定了前綴為"my.list"，而MyConfig類中定義了一個List<String>類型的屬性list，用來存儲配置文件中以"my.list"為前綴的數據。這樣一來，就可以方便地訪問配置文件中的List類型數據了。如果需要綁定Array類型的數據，只需要將List類型改為對應的Array類型即可。

範例：

- application.yml

```yaml
# 配置集合
# 數組 和 List 一樣的，使用 「-」 一個成員
names:
  - Lisa
  - Susan
# List<MyServer> servers
servers:
  - title: tomcat服務器
    ip: localhost.8081
  - title: xxx服務器
    ip: 202.12.11.2
# Map<String, User> users
users:
  user1:
    name: Mini
    sex: 女
    age: 26
  user2:
    name: Vito
    sex: 男
    age: 8
```

- 建立 User、MyServer

```java
public class User {
    private String name;
    private String sex;
    private String age;
		// getter and setter and toString
}
```

```java
public class MyServer {
    private String title;
    private String ip;
		// getter and setter and toString
}
```

- 建立Configuration類

```java
@ConfigurationProperties
public class CollectionConfig {

    private List<MyServer> servers;
    private Map<String, User> users;
    private String[] names;
		// getter and setter and toString
}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/85b40b79-3afa-416a-aeb7-9d7708675131/Untitled.png)

### 指定數據源文件

在 Spring Boot 中，我們可以使用 `@PropertySource` 註解來指定數據源文件。這個註解用於加載指定的 properties 文件或者 XML 文件，並將其轉換成對應的 Java 對象。同時，我們還可以使用 `@Configuration` 註解來設置配置類，並使用 `@Value` 或者 `@ConfigurationProperties` 來綁定屬性值。

其中，`@Value` 註解用於綁定單個屬性值，另外，`@ConfigurationProperties` 註解用於綁定多個屬性值

除此以外，我們還可以使用 `@PropertySource` 註解來指定 properties 文件或者 XML 文件的路徑，例如：

```java
@Configuration
@PropertySource("classpath:config.properties")
public class MyConfig {

    @Value("${my.property}")
    private String myProperty;

    // getter and setter
}

```

在上面的例子中，`@PropertySource` 註解指定了要加載的 properties 文件的路徑，並使用 `@Value` 註解來綁定屬性值。需要注意的是，路徑需要使用 `classpath:` 前綴來指定文件位於 classpath 下。另外，如果要加載 XML 文件，只需要將 `@PropertySource` 註解中的路徑修改為 XML 文件的路徑即可。

需要注意的是，在使用 `@PropertySource` 註解時，需要確保該註解所在的類被 Spring 容器管理。另外，`@Value` 和 `@ConfigurationProperties` 註解需要配合 `@Component` 或者其他相關註解一起使用，以便讓 Spring Boot 能夠自動注入對應的 Java 對象。

範例：

- 建立group-info.properties

```java
group.name=Java learning
group.leader=teacher
group.members=100

app.name=xxx
app.author=123
app.version=1.0
```

- 建立Group

```java
@Configuration
@ConfigurationProperties(prefix = "group")
@PropertySource(value = "classpath:/group-info.properties")
public class Group {

    private String name;
    private String leader;
    private Integer members;
		// getter and setter and toString
}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ab659975-83e1-424d-81af-9fc71f95834e/Untitled.png)

## 創建object三種方式

將 object 注入到 Spring 容器，可以透過如下方式：

- 傳統的 XML 配置文件
- Java Config 技術，@Configuration 與 @Bean
- 創建 object 的註解，@Controller、@Service、@Repository、@Component

Spring Boot 不建議使用 xml 文件的方式，自動配置已經解決了大部分 xml 中的工作了。如果需要 xml 提供 Bean 的聲明，使用 @ImportResource 加載 xml 註冊 Bean。

範例：

- 創建 Person，object 由容器管理

```java
public class Person {
    private String name;
    private String age;
		// getter and setter and toString
}
```

- 建立 applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!-- 聲明bean對象 -->
    <bean id="myPerson" class="com.example.configure.pk10.Person">
        <property name="name" value="Lisa"/>
        <property name="age" value="26"/>
    </bean>
</beans>
```

- 在配置類加入註解@ImportResource

```java
@ConfigurationPropertiesScan(basePackages = {"com.example.configure.pk6", "com.example.configure.pk8"})
@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class Lesson7ConfigureApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Lesson7ConfigureApplication.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println("bean = " + bean);

    }

}
```

在 Spring 中，我們可以使用三種方式來創建 object 並注入到 Spring 容器中。

第一種方式是傳統的 XML 配置文件，通過在 XML 文件中聲明 Bean，然後在 Java 代碼中通過 Spring 容器來獲取對應的 Bean。例如：

```xml
<bean id="myBean" class="com.example.MyBean">
    <property name="name" value="John" />
    <property name="age" value="30" />
</bean>
```

在上面的例子中，我們聲明了一個 id 為 `myBean` 的 Bean，並指定了其對應的 Java 類為 `com.example.MyBean`。同時，我們還通過 `property` 元素來設置對應的屬性值。

第二種方式是使用 Java Config 技術，通過在 Java 類中聲明 `@Configuration` 和 `@Bean` 註解來創建 Bean。例如：

```java
@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("John");
        myBean.setAge(30);
        return myBean;
    }
}
```

在上面的例子中，我們聲明了一個名為 `myBean` 的 Bean，並使用 `@Bean` 註解來標記其為一個 Bean。同時，我們還可以在對應的方法中設置對應的屬性值。

第三種方式是使用創建 object 的註解，例如 `@Controller`、`@Service`、`@Repository` 和 `@Component` 等。例如：

```java
@Service
public class MyService {

    @Autowired
    private MyDao myDao;

    public void doSomething() {
        // do something
    }
}
```

在上面的例子中，我們使用 `@Service` 註解來聲明一個名為 `myService` 的 Bean，同時使用 `@Autowired` 註解來自動注入一個名為 `myDao` 的 Bean。這樣一來，Spring Boot 就會自動創建對應的 Bean，並注入到 Spring 容器中。

需要注意的是，在使用第三種方式時，需要確保對應的註解所在的類被 Spring 容器管理。另外，如果需要從 Spring 容器中獲取對應的 Bean，可以使用 `@Autowired` 或者 `@Resource` 註解來自動注入對應的 Bean。

## AOP

AOP(Aspect Oriented Programming)是一種面向切面編程的技術，它能夠在不改變原有代碼的情況下，給原有的業務邏輯增加功能。這些功能是由開發人員自己編寫的，底層是通過動態代理實現的。AOP對於擴展功能十分有利，而Spring的事物功能就是在AOP基礎上實現的。當業務方法執行前需要**開啟事務**，在執行業務方法後，最後**提交或回滾失敗**。

- Aspect：表示切面，是開發人員編寫功能增強代碼的地方，這些代碼會透過動態代理加入到原有的業務方法中。`@Aspect` 表示當前類是切面類，切面類是一個普通類
- Joinpoint：表示連接點，連接切面和目標對象。或是一個方法名稱，一個package名，class名。在這個特定的位置執行切面中的功能代碼
- Pointcut(切入點)：用於連接切面和目標對象。Pointcut則是篩選出的連接點，一個類中的所有方法都可以是Joinpoint，具體哪個方法要增加功能就是Pointcut
- Advice：通知，也叫做增加。表示增加的功能執行時間。Java 代碼執行的單位是方法，方法是業務邏輯代碼，在方法之前增加新的功能，還是方法之後增加功能，表示在方法前，後等的就是通知。

主要包括 5 個註解：@Before、@After、@AfterRunning、@AfterThrowing、@Around。註解來自 aspectj 框架。

@Before：在切點方法之前執行。

@After：在切點方法之後執行。

@AfterRunning：切點方法返回執行。

@AfterThrowing：切點方法拋異常執行

@Around：屬於環繞增強，能控制切點執行前、執行後。功能最強的註解。

- Target Object：目標對象。在 A 類的 print() 執行前，輸出方法的執行時間。也就是給 A 這個物件增加了 *輸出執行時間的功能*。

AOP 技術主要的實現一個是 Spring 框架，Spring Boot 也支持：另一個是功能全面的 AspectJ 框架。Spring Boot 執行 AspectJ框架，使用@Before、@After、@AfterRunning、@AfterThrowing、@Around註解的方式就來自 AspectJ 框架的功能

- 範例：
- Maven 添加 app 依賴

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

- 建立service類

```java
@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void query(Integer id) {
        System.out.println("SomeService業務方法query執行了");
    }

    @Override
    public void save(String name, int age) {
        System.out.println("SomeService業務方法save執行了");
    }
}
```

- 建立asecpt類

```java
@Component
@Aspect
public class LogAspect {

    // service這個package和子package中{service.} 的 任意類{.*} 的 任意方法{.*} 任意的參數(..)
    @Before("execution(* com.example.aop.service..*.*(..))")
    // 功能增強的方法
    public void sysLog(JoinPoint joinPoint) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        log.add(formatter.format(LocalDateTime.now()));

        // 當前執行的業務方法名稱
        String methodName = joinPoint.getSignature().getName();

        // 目標方法參數列表
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }
        System.out.println("方法執行日誌： " + log);
    }

}
```

- 測試打印

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/816906f1-e871-4a0f-93ea-d88bd48ebd19/Untitled.png)

# 自動配置

在 Spring Boot 中，啟用 autoconfigure (自動配置) 可以讓框架自動猜測和創建需要的 Bean，大大簡化了開發人員的工作。

- 例如：當我們使用第三方框架 MyBatis 時，可以使用 mybatis-spring-boot-starter 來引入 MyBatisAutoConfiguration 自動配置類。這個自動配置類會從類路徑中尋找 mybatis.jar，並創建 SqlSessionFactory 和 Datasource 數據源對象，讓我們可以方便地訪問數據。

這些工作交給 XXXAutoCinfiguration 類，第三方框架的 starter 裡面包含了自己 XXXAutoConfiguration

第三方框架 MyBatis，mybatis-spring-boot-starter 的 MyBatisAutoConfiguration 自動配置類

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6f5ef14b-ded5-4f4b-b48d-d734751dfdb1/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6a52a56e-0d93-4c4a-a459-2c26dae8cd46/Untitled.png)

- org.springframework.boot:spring-boot-autoconfigure/META-INF/spring-autoconfigure-metadata.properties

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6476f18c-ff24-458f-8abe-717519208cec/Untitled.png)

使用 @EnableAutoConfiguration 註解來啟用自動配置，通常由@SpringBootApplication 註解帶入。@EnableAutoConfiguration 所在的 package 具有特殊的含義，是 Spring Boot 中的默認包，也是掃描包的起點(root 包)。因此，@Controller、@Service、@Repository、@Component、@Configuration 放在 root 包以及子包中都會被掃瞄到。這樣的設計讓開發人員可以更方便地管理和使用 Spring Bean。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d0036c24-9ea2-4bd9-928c-fb64cefc5517/Untitled.png)

# 訪問資料庫
Spring Boot 框架提供了廣泛的數據庫支持，包括使用 JdbcTemplate 直接訪問 JDBC，以及支持多種 ***object relational mapping*** 技術，如 Hibernate 和 MyBatis。此外，Spring Data 項目也提供了對多種關係型和非關係型數據庫的訪問支持，如 MySQL、Oracle、MongoDB、Redis、R2DBC、Apache Solr 和 Elasticsearch。對於嵌入式數據庫，Spring Boot 也提供了支持，如 H2、HSQL 和 Derby。這些數據庫只需要提供 jar 包就能在內存中維護數據。

## Datasource

在 Java 項目中，通常會使用 MySQL、Oracle、PostgreSQL 等大型關係數據庫。要在代碼中訪問數據庫，我們需要知道數據庫程序所在的 IP、端口、訪問數據庫的用戶名和密碼以及數據庫的類型信息。這些信息用來初始化數據源，數據源也就是 DataSource。DataSource 表示數據的來源，從某個 IP 上的數據庫能夠獲取數據。在 Java 中，javax.sql.DataSource 接口表示數據源，提供了標準的方法獲取與數據庫綁定的連接對象（Connection）。

javax.sql.Connection 是連接對象，在 Connection 上能夠從程序代碼發送查詢命令，更新數據的語句給數據庫；同時從 Connection 獲取命令的執行結果。Connection 就像一個電話線，把應用程序和數據庫連接起來。在 Java 中，我們可以使用 JDBC 技術來訪問關係型數據庫，通過 DataSource 和 Connection 對象來實現與數據庫的交互。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d82d4b57-1008-4ef5-ab99-ac934ef32396/Untitled.png)

DataSource 在 Spring Boot 的 application 配置文件中以 spring.datasource.* 作為配置項。例如：

```yaml
spring:
	datasource:
		url: jdbc:mysql://localhost/mydb
		username: dbuser
		password: dbpass
```

這裡的 url、username 和 password 分別表示數據庫的 URL、用戶名和密碼。在配置文件中，我們還可以設置其他數據庫連接池的相關配置，如最大活動連接數、最大空閒連接數、最小空閒連接數、連接超時時間等。這些配置項都以 spring.datasource.* 的形式出現。

在 Spring Boot 中，DataSourceProperties 是數據源的配置類，它使用了 @ConfigurationProperties 注解，可以將配置文件中的屬性值映射到對應的屬性上。通過這個類，我們可以設置數據源的 URL、用戶名、密碼等屬性，同時也可以設置其他數據庫連接池的相關配置。

```java
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties implements BeanClassLoaderAware, InitializingBean {
}
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0d3cc8ab-0a96-4d16-990f-0ace972f5a75/Untitled.gif)

Spring Boot 框架提供了對多種數據庫連接池的支持，優先使用 HikariCP 連接池，其次是 Tomcat pooling，再次是 Commons DBCP2，如果以上都沒有，最後會使用 Oracle UCP 連接池。當項目中添加了 spring-boot-starter-jdbc 或者 spring-boot-starter-data-jpa 依賴時，默認會添加 HikariCP 連接池依賴，也就是默認使用 HikariCP 連接池。HikariCP 是當前性能最好的連接池之一，它具有極高的性能和低的內存占用，能夠有效地減少數據庫連接的等待時間和資源消耗。因此，在開發 Spring Boot 項目時，推薦使用 HikariCP 連接池。

## 輕量的 JdbcTemplate

Spring 提供了 JdbcTemplate 和 NamedParameterJdbcTemplate 這兩個類，方便開發者使用 JDBC 執行 SQL 語句。JdbcTemplate 是對 JDBC 的封裝，可以直接執行完整的 SQL 語句，只需要將 SQL 語句拼接好，交給 JdbcTemplate 執行即可。而 NamedParameterJdbcTemplate 則提供了更好的可讀性，可以在 SQL 語句部分使用***:命名參數***作為佔位符，對參數進行命名，使得代碼更加易讀。NamedParameterJdbcTemplate 包裝了 JdbcTemplate 對象，對***:命名參數***進行解析後，交給 JdbcTemplate 執行 SQL 語句。

在 Spring Boot 中，使用 JdbcTemplate 和 NamedParameterJdbcTemplate 非常方便，因為 Spring Boot 會自動進行配置。具體來說，JdbcTemplateAutoConfiguration 自動配置了 JdbcTemplate 對象，並由 JdbcTemplateConfiguration 創建 JdbcTemplate 對象。此外，JdbcTemplateAutoConfiguration 還對 JdbcTemplate 做了簡單的初始設置，如 QueryTimeout 和 maxRows 等，這樣開發者就無需進行過多的配置，可以直接使用 JdbcTemplate 和 NamedParameterJdbcTemplate。使用 @Autowire 注入這些對象到自己的 Bean 中即可開箱即用。

範例：

- pom.xml 中增加依賴

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

- IDEA Maven Tool 查看依賴列表

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/622c1856-d0c5-4d8d-929c-0b681a659173/Untitled.png)

依賴包含了連接池 `com.zaxxer:HikariCP:5.0.1`、`spring-jdbc:6.0.7`、mysql 驅動 `mysql-connector-j:8.0.32`。

- 在資料庫新增schema blog後，在 resources 資料夾下建立，`schema.sql`、`data.sql`

```sql
CREATE TABLE `article`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主間',
    `user_id`     int(11) NOT NULL COMMENT '作者 ID',
    `title`       varchar(100) NOT NULL COMMENT '文章標題',
    `summary`     varchar(200) DEFAULT NULL COMMENT '文章概要',
    `read_count`  int(11) unsigned zerofill NOT NULL COMMENT '閱讀讀數',
    `create_time` datetime     NOT NULL COMMENT '創建時間',
    `update_time` datetime     NOT NULL COMMENT '最後修改時間',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
```

```sql
INSERT INTO `article`
VALUES ('1', '2101', 'SpringBoot 核心注解',
        '核心注解的主要作用', '00000008976', '2023-01-16 12:11:12', '2023-01-16 12:11:19');
INSERT INTO `article`
VALUES ('2', '356752', 'JVM 調優',
        'HotSpot 虛擬機詳解', '00000000026', '2023-01-16 12:15:27', '2023-01-16 12:15:30');
```

- 在 application.yml 配置數據源

```yaml
# 配置數據源
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog
    username: root
    password: 1234
# 設置執行資料庫腳本 always：總是執行，never：不執行了
  sql:
    init:
      mode: never
```

項目中依賴了 spring-jdbc 6.0.7，JdbcTemplate 對象會自動創建好。把 JdbcTemplate 對象注入給你的 Bean，再調用 JdbcTemplate 的方法執行查詢，更新，刪除的 SQL。
JdbcTemplate 上手快，功能非常強大。提供了豐富、實用的方法，歸納起來主要有以下幾種類型的方法：
（1）execute 方法：可以用於執行任何 SQL 語句，常用來執行 DDL 語句。
（2）update、batchUpdate 方法：用於執行新增、修改與刪除等語句。
（3）query 和 queryForXXX 方法：用於執行查詢相關的語句。
（4）call 方法：用於執行數據庫存儲過程和函數相關的語句。

範例：

- 單元測試

```java
@Resource
private JdbcTemplate jdbcTemplate;
```

```java
@Test
void testCount() {
    String sql = "SELECT count(*) AS ct FROM article";
    Long count = jdbcTemplate.queryForObject(sql, Long.class);
    System.out.println("文章總數：" + count);
}
```

```java
@Test
void testQuery() {
    // ? 作為占位符
    String sql = "SELECT * FROM article where id = ?";
    // BeanPropertyRowMapper 將查詢的結果集、列名與屬性名稱匹配，名稱完全匹配或駝峰
    ArticlePO article = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePO.class), 2);
    System.out.println("查詢到的文章 = " + article);
}
```

```java
@Test
void testQueryRowMapper() {
    // 只能查詢出一個紀錄，查詢不出紀錄拋出異常
    String sql = "SELECT * FROM article WHERE id = " + 1;
    ArticlePO article = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
        var id = rs.getInt("id");
        var userId = rs.getInt("user_id");
        var title = rs.getString("title");
        var summary = rs.getString("summary");
        var readCount = rs.getInt("read_count");
        var createTime = new Timestamp(rs.getTimestamp("create_time").getTime()).toLocalDateTime();
        var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime()).toLocalDateTime();
        return new ArticlePO(id, userId, title, summary, readCount, createTime, updateTime);
    });
    System.out.println("查詢的文章 = " + article);
}
```

```java
@Test
void testList() {
    String sql = "SELECT * FROM article ORDER BY id";
    // 一個list成員是一行紀錄，Map是列名和值
    List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
    maps.forEach(item -> {
        item.forEach((key, value) -> {
            System.out.println("字段名稱： " + key + ", 列值: " + value);
        });
        System.out.println("==========================");
    });
}
```

```java
@Test
void testUpdate() {
    String sql = "UPDATE article SET title = ? WHERE id = ?";
    // 參數是從左往右 第一個，第二個...
    int updated = jdbcTemplate.update(sql, "Java 核心技術思想", 2);
    System.out.println("更新紀錄：" + updated);
}
```

### NamedParameterJdbcTemplate

NamedParameterJdbcTemplate 是 JdbcTemplate 的一個擴展，主要用於提高 SQL 語句的可讀性。NamedParameterJdbcTemplate 可以接受命名的參數，而 JdbcTemplate 使用的是參數索引的方式。通過使用具名的參數，我們可以提高代碼的可讀性。

使用 NamedParameterJdbcTemplate 的步驟如下：

1. 首先，在使用模板的位置注入 NamedParameterJdbcTemplate 對象
2. 編寫 SQL 語句，其中在 WHERE 部分使用“:命名參數”作為佔位符。
3. 最後，當調用 NamedParameterJdbcTemplate 的方法，如 query、queryForObject、execute 和 update 等時，我們需要將參數封裝到 Map 中，並將該 Map 對象作為參數傳遞給方法。

這樣 NamedParameterJdbcTemplate 就可以將 ***:命名參數*** 映射到 Map 中對應的參數值上，最終執行 SQL 語句。

除了提供更好的可讀性外，NamedParameterJdbcTemplate 還可以防止 SQL 注入攻擊，因為 NamedParameterJdbcTemplate 會自動將參數進行處理，使得攻擊者無法通過參數傳入惡意的 SQL 語句。這樣可以提高應用的安全性。

範例：

- 單元測試

```java
@Resource                                             
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
```

```java
@Test
void testNameQuery() {
    // :參數名
    String sql = "SELECT COUNT(*) AS ct FROM article WHERE user_id = :uid AND read_count > :num";
    // key是命名參數
    Map<String, Object> param = new HashMap<>();
    param.put("uid", 2101);
    param.put("num", 10);
    Long count = namedParameterJdbcTemplate.queryForObject(sql, param, Long.class);
    System.out.println("用戶被閱讀的文章數量 = " + count);
}
```

### 多表查詢

當進行多表查詢時，我們需要關注如何將查詢結果映射為 Java Object。通常有兩種方案：

1. 將查詢結果轉為 Map，這種方式比較通用，適合查詢任何表。
2. 根據查詢結果中包含的列，創建相對的實體類，將查詢結果映射為實體類對象。

如果採用第一種方案，我們可以使用 JdbcTemplate 的 query 方法，該方法返回一個 List<Map<String, Object>> 對象，其中每個 Map 對象表示一行查詢結果。Map 中的 key 是列名，value 是列的值。這種方式比較簡單，但是需要手動處理類型轉換。

如果採用第二種方案，我們需要自定義 RowMapper 或 ResultSetExtractor。通過實現 RowMapper 或 ResultSetExtractor 接口，我們可以自定義如何映射查詢結果為對應的實體類對象。在進行映射時，我們需要將查詢結果中的列與實體類中的屬性進行對應，通常可以使用 BeanPropertyRowMapper 或者自定義 RowMapper 實現。這種方式比較靈活，能夠更好地控制映射邏輯。

例如，現在我們需要創建一個新表 article_detail，該表存儲文章內容，與 article 表是一對一關係。如果我們需要在查詢 article 表時同時查詢 article_detail 表的內容，可以使用 JOIN 操作，然後自定義 RowMapper 或 ResultSetExtractor 將查詢結果映射為對應的 Java Object。

範例：

- 單元測試

```java
String sql= """
select m.*,d.id as detail_id, d.article_id,d.content
from article m join article_detail d
on m.id = d.article_id
where m.id=:id
""";
Map<String,Object> param = new HashMap<>();
param.put("id", 1);
List<ArticleMainPO> list = nameJdbcTemplate.query(sql, param, (rs, rowNum) -> {
var id = rs.getInt("id");
var userId = rs.getInt("user_id");
var title = rs.getString("title");
var summary = rs.getString("summary");
var readCount = rs.getInt("read_count");
var createTime = new Timestamp(rs.getTimestamp("create_time").getTime())
.toLocalDateTime();
var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime())
.toLocalDateTime();
//文章详情
var detailId = rs.getInt("detail_id");
var content = rs.getString("content");
var articleId = rs.getInt("article_id");
ArticleDetailPO detail = new ArticleDetailPO();
detail.setId(detailId);
detail.setArticleId(articleId);
detail.setContent(content);
return new ArticleMainPO(id, userId, title, summary, readCount,
createTime, updateTime, detail);
});
list.forEach(m -> {
System.out.println("m.getId() = " + m.getId());
System.out.println("m.getArticleDetail() = " + m.getArticleDetail());
});
```

### 總結

JdbcTemplate 是 Spring 框架中一個簡單靈活的數據訪問工具，它可以訪問多種數據庫。這個工具對於數據的處理控制能力比較強，可以透過 RowMapper 和 ResultSetExtractor 這兩個類別，提供按需要靈活定制記錄集與實體類的關係。但是，由於 JdbcTemplate 對 SQL 的要求比較高，適合對 SQL 比較了解的開發人員使用。同時，自定義查詢結果也需要較多的代碼實現，且調優需求相對較高。

在使用 JdbcTemplate 時，可以通過設置一些配置項目來調整 JdbcTemplate 對象的一些參數。其中，可設置的配置項目以 **`spring.jdbc.template.`** 開頭。例如，要設置超時為 10 秒，可以設置 **`spring.jdbc.template.query-timeout=10`**。這樣可以提高數據庫操作的效率。

## MyBatis

MyBatis 是一個流行的 ORM 框架，主要使用 mapper xml 文件編寫 SQL 語句。除此之外，MyBatis 也支持使用註解、JDK 新特性文本塊等方式編寫 SQL 語句。

在使用 MyBatis 的註解編寫 SQL 語句時，需要使用到一些常用的註解，如 @Select、@Insert、@Update、@Delete 等。通過這些註解，可以方便地在 Java 類中定義 SQL 語句，不需要額外的 mapper xml 文件。

此外，JDK 新特性文本塊也是 MyBatis 編寫 SQL 語句的一種方式。它可以將 SQL 語句作為一個文本塊，嵌入到 Java 代碼中，使得代碼更加簡潔易讀。

除了 SQL 語句的編寫方式，MyBatis 還提供了一個名為 Record 的工具類，用於完成 Java 對象和表數據之間的轉換。Record 是一個類似於 Map 的對象，可以存儲表數據的每一列和對應的值。通過使用 Record，可以方便地進行數據庫操作，而不需要手動編寫 SQL 語句。

總體來說，MyBatis 作為一個強大的 ORM 框架，提供了多種編寫 SQL 語句的方式，並且提供了方便的工具類幫助開發人員進行數據庫操作。

### 單表CRUD

首先向 blog 數據庫的 article 表添加新的文章，以及修改，查詢文章。在新工程 Lession10-MyBatis 集成 MyBatis框架。項目包名 com.bjpowernode.orm。依賴需要 mysql 驅動、mybatis 依賴，Lombok。

範例：

- pom.xml 中增加依賴

```xml
<!-- MyBatis啟動器 (MyBatis團隊提供的) -->
<dependency>
	<groupId>org.mybatis.spring.boot</groupId>
	<artifactId>mybatis-spring-boot-starter</artifactId>
	<version>3.0.0</version>
</dependency>
<dependency>
	<groupId>com.mysql</groupId>
	<artifactId>mysql-connector-j</artifactId>
	<scope>runtime</scope>
</dependency>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
	<optional>true</optional>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

- 在 application.yml 配置資料庫、創建model ArticlePO
- 建立 Mapper 介面

```java
public interface ArticleMapper {
    // 按主鍵查詢
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{articleId} 
            """)
    ArticlePO selectById(@Param("articleId") Integer id);
}
```

- 在啟動類加入注解掃描 `@MapperScan`

```java
@MapperScan(basePackages = "com.example.mybatis.mapper")
@SpringBootApplication
public class Lesson10MyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson10MyBatisApplication.class, args);
	}

}
```

---

這邊會碰到一個問題，column 與 model 的屬性值對不上

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e94b97a6-646b-447b-b695-6e6dba6e09ed/Untitled.png)

解決方法：

1. 在 application.yml 配置 `mybatis.configura tion.map-underscore-to-camel-case=true`

```yaml
# 配置數據源
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog
    username: root
    password: 1234

# 配置mybatis
mybatis:
  configuration:
    # 啟動駝峰命名、下划線命名
    map-underscore-to-camel-case: true
```

1. 在 mapper 上方添加注解 @Results

```java
// 按主鍵查詢
@Select("""
        SELECT id, user_id, title, summary, read_count, create_time, update_time
        FROM article
        WHERE id = #{articleId} 
        """)
// 查詢結果ResultSet 和 PO對象的屬性映射
@Results(id = "BaseArticleMap", value = {
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "user_id", property = "userId"),
        @Result(column = "read_count", property = "readCount"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime")
})
ArticlePO selectById(@Param("articleId") Integer id);
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0a9be13b-b75c-484d-956f-4fd843289b6f/Untitled.png)

```java
public interface ArticleMapper {
    // 按主鍵查詢
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{articleId} 
            """)
    // 查詢結果ResultSet 和 PO對象的屬性映射
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ArticlePO selectById(@Param("articleId") Integer id);

    // insert
    @Insert("""
            INSERT INTO article(user_id, title, summary, read_count, create_time, update_time)
            VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    int insertAritcle(ArticlePO po);

    // update
    @Update("""
            UPDATE article SET read_count = #{readCount} WHERE id = #{id}
            """)
    void updateReadCount(Integer id, Integer readCount);

    // delete
    @Delete("""
            DELETE FROM article WHERE id = #{id}
            """)
    void deleteById(Integer id);
}
```

### ResultMap

ResultMap：結果映射，將查詢結果中的列和實體 Bean 的屬性對應關係。透過在 xml 文件使用 <resultMap> 標籤定義映射關係，例如：<select resultMap=”xxx”>

查詢操作得到包含多個列的集合，將列值轉為物件屬性使用結果映射的功能，註解 `@Results`、`@ResultMap` 能夠幫助我們完成此功能。

- `@Results`：用於定義結果映射，每個列和 Java 物件屬性的一一對應。
- `@ResultMap`：指定使用哪個結果映射，兩種方式可以使用 `@Results`，另一種 XML 文件

範例：

1. 創建 Mapper object

```java
public interface ArticleDao {

    // 1. 查詢某個用戶的所有文章
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article WHERE user_id=#{userId}
            """)
    @Results(id = "BaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    List<ArticlePO> selectList(Integer userId);

    // 2. 查詢某個文章，使用id
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article WHERE id=#{id}
            """)
    // 引用定義好的結果映射，value的值是@Results中的id
    @ResultMap("BaseArticleMap")
    ArticlePO selectById(Integer id);

}
```

1. 另一種方法在 xml 中定義<resultMap>標籤，在 `@ResultMap` 引用。這種方式首先創建 xml。在 resources 目錄下創建自定義的 mapper 目錄。
    1. 新建 `ArticleMapper.xml`
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9eb7b7f-c6c3-49f4-bb48-008ea3cffa5c/Untitled.png)
        
        ```xml
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper
                PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <mapper namespace="com.example.mybatis.mapper.ArticleDao">
            <resultMap id="ArticleBaseMapper" type="com.example.mybatis.po.ArticlePO">
                <id column="id" property="id"/>
                <result column="user_id" property="userId"/>
                <result column="read_count" property="readCount"/>
                <result column="create_time" property="createTime"/>
                <result column="update_time" property="updateTime"/>
            </resultMap>
        </mapper>
        ```
        
    2. 修改 `application.properties` 配置 mapper 路徑
        
        ```yaml
        # 配置mybatis
        mybatis:
          configuration:
            # 啟動駝峰命名、下划線命名
        #    map-underscore-to-camel-case: true
            # 日誌
            log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
          # 自定義mapper文件位置、mappers裡面以及任意子目錄的*.xml
          mapper-locations: classpath:/mappers/**/*.xml
        ```
        
    3. Dao 中新增方法
        
        ```java
        // 使用xml中的<resultMap>的id
        @Select("""
                SELECT id, user_id, title, summary, read_count, create_time, update_time
                FROM article WHERE id=#{id}
                """)
        @ResultMap("ArticleBaseMapper")
        ArticlePO selectByIdByXml(Integer id);
        ```
        

## SQL Provider

可以使用 Text Block 編寫長的 SQL 語句，而不是在方法中直接編寫 SQL。這樣做可以讓 SQL 更加簡潔易讀。

MyBatis 提供了 SQL 提供者的功能，將 SQL 以方法的形式定義在單獨的類中。通過引用 SQL 提供者中的方法名稱，Mapper 接口可以表示要執行的 SQL。

SQL 提供者有四類：`@SelectProvider`、`@InsertProvider`、、`UpdateProvider` 和 `@DeleteProvider`。

SQLProvider 首先創建提供者類，並聲明靜態方法，方法體是 SQL 語句並返回 SQL。例如：

```java
public static String selectById() {
	return "SELECT * FROM users WHERE id = #{id}";
}
```

其次，在 Mapper 介面的方法上面，使用 `@SelectProvider(type = 提供者類.class, method = "方法名稱")` 來應用對應的提供者類和方法名稱。

範例：

- 創建 SqlProvider

```java
public class SqlProvider {

    // 定義static方法
    public static String selectArticle() {
        return "SELECT * FROM article WHERE id = #{id}";
    }

    public static String updateSql() {
        return "UPDATE article SET update_time = #{now} WHERE id = #{id}";
    }

    public static String insertSql() {
        return """
                INSERT INTO article(user_id, title, summary, read_count, create_time, update_time) 
                VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
                """;
    }

    public static String deleteSql() {
        return """
                DELETE FROM article WHERE id = #{articleId}
                """;
    }
}
```

- 創建 mapper

```java
public interface ArticleRepository {
    // 定義 @Results
    @Select("")
    @Results(id = "NewBaseArticleMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    ArticlePO articleMapper();

    // 使用SqlProvider
    @ResultMap("NewBaseArticleMap")
    @SelectProvider(type = SqlProvider.class, method = "selectArticle")
    ArticlePO selectPrimary(Integer id);

    @UpdateProvider(type = SqlProvider.class, method = "updateSql")
    int updateTime(Integer id, LocalDateTime now);
}
```

### `@One` 一對一查詢

MyBatis 支持一對一，一對多，多對多查詢。 XML 文件和註解都能實現關係的操作。

使用註解表示 article和 article_detail 的一對一關係。 MyBatis 維護這個關係， 開發人員自己也可以維護這種關係。

- `@One`：一對一
- `@Many`： 一對多

範例：

關係表一個 article 有一個article_detail 文章內容

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/14c90712-b04e-4466-a148-b75bd0bcccd9/Untitled.png)

- 創建 Entity

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // 一對一關係
    private ArticleDetail articleDetail;
}
```

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetail {
    private Integer id;
    private Integer articleId;
    private String content;
}
```

- Mapper 查詢介面

```java
public interface ArticleOneToOneMapper {
    // 一對一查詢
    // 查詢文章詳情
    @Select("""
            SELECT id, article_id, content FROM article_detail
            WHERE article_id = #{articleId}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetail selectDetail(Integer articleId);

    // 查詢文章屬性、包括詳情
    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{id}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "articleDetail",
                    one = @One(select = "com.example.mybatis.mapper.ArticleOneToOneMapper.selectDetail",
                            fetchType = FetchType.LAZY))
    })
    Article selectAllArticle(Integer id);

}
```

### `@Many` 一對多查詢

一對一查詢使用 `@Many`，步驟與一對一基本相同

範例：

有一個 table：comment，article 與 comment 存在一對多關係，一篇文章多個評論

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1d5ae2d9-6bd7-491c-a1b8-7f2f400e8149/Untitled.png)

- 創建 Entity

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // 多個評論、一對多
    private List<Comment> comments;
}
```

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;
    private Integer articleId;
    private String content;
}
```

- 創建 Mapper 介面

```java
public interface ArticleCommentMapper {
    // 查詢評論
    @Select("""
            SELECT id, article_id, content FROM comment
            WHERE article_id = #{articleId}
            ORDER BY id
            """)
    @Results(id = "CommentMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    List<Comment> selectComments(Integer articleId);

    @Select("""
            SELECT id, user_id, title, summary, read_count, create_time, update_time
            FROM article
            WHERE id = #{id}
            """)
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "id", property = "comments",
                    many = @Many(select = "com.example.mybatis.mapper.oneToMany.ArticleCommentMapper.selectComments",
                    fetchType = FetchType.LAZY))
    })
    ArticleEntity selectArticleComments(Integer id);
}
```

### 常用配置參數

在 application 文件中，MyBatis 的設置屬性通常以`mybatis`開頭，全部設置可參考 [**官網**](https://mybatis.org/mybatis-3/zh/configuration.html#settings)。

常用設置：

```yaml
mybatis:
  configuration:
    # 駝峰命名法
    map-underscore-to-camel-case: true
    # 啟用緩存
    cache-enabled: true
    # 延遲加載
    lazy-loading-enabled: true
  # mapper xml 文件位置
  mapper-locations: classpath:/mappers/**/*.xml
  # mybatis 主配置文件，按需求使用，上面其他註解掉
  config-location: classpath:/sql-config.xml
```

上述設置內容比較多時，可以將設置放到 MyBatis 主配置文件，`mybatis.config-location` 加載主配置文件。

- `sql-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <setting name="cacheEnabled" value="true"/>
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <typeAliases>
        <package name="com.bjpowernode.po"/>
    </typeAliases>
</configuration>
```

### MyBatisAutoConfiguration

MyBatis 框架在 Spring Boot 的自動配置類 `MybatisAutoConfiguration.class`

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6d34a2b8-d869-4dcf-ac66-ef1b178e6d44/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/352d854c-87df-44c1-9d3e-efd274c4031f/Untitled.png)

imports 文件中定義了 `org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration` 自動配置

```java
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
@ConditionalOnSingleCandidate(DataSource.class)
@EnableConfigurationProperties({MybatisProperties.class})
@AutoConfigureAfter({DataSourceAutoConfiguration.class,
MybatisLanguageDriverAutoConfiguration.class})
public class MybatisAutoConfiguration implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(MybatisAutoConfiguration.class);
	private final MybatisProperties properties;
	.....
}
```

```java
@Bean
@ConditionalOnMissingBean
public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
{
SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
factory.setDataSource(dataSource);
....
}
@Bean
@ConditionalOnMissingBean
public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
ExecutorType executorType = this.properties.getExecutorType();
return executorType != null ? new SqlSessionTemplate(sqlSessionFactory,
executorType) : new SqlSessionTemplate(sqlSessionFactory);
}
```

SqlSessionTemplate 是線程安全的，MyBatis 為了與 Spring 繼承。提供的由 Spring 管理的 Bean。這個SqlSesionTemplate 實現了 SqlSession 介面， 能夠由 Spring 事務管理器使用。提供 Spring 的事務處理。同時管理 SqlSession 的創建，銷毀。

## 適合的連接池

- [HikariCP 連接池](https://github.com/brettwooldridge/HikariCP/wiki)
- [連接池配置](https://github.com/brettwooldridge/HikariCP/wiki/About-Pool-Sizing)
- [MySQL 連接池配置建議](https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration)
    
    `prepStmtCacheSize`：This sets the number of prepared statements that the MySQL driver will cache per connection. The default is a conservative *25*. We recommend setting this to between *250-500*.
    
    這個設置了 MySQL 驅動程式在每個連接中緩存的預備語句數量。預設值是保守的 25，我們建議將其設置在 250 到 500 之間。
    
    `prepStmtCacheSqlLimit`：This is the maximum length of a prepared SQL statement that the driver will cache. The MySQL default is *256*. In our experience, especially with ORM frameworks like Hibernate, this default is well below the threshold of generated statement lengths. Our recommended setting is *2048*.
    
    這是驅動程式將緩存的預備 SQL 語句的最大長度。MySQL 的默認值為 256。根據我們的經驗，特別是對於像 Hibernate 這樣的 ORM 框架，這個默認值遠低於生成的語句長度閾值。我們建議將其設置為 2048。
    
    `cachePrepStmts`：Neither of the above parameters have any effect if the cache is in fact disabled, as it is by default. You must set this parameter to `true`.
    
    如果緩存被禁用（默認情況下），則上述兩個參數都不起作用。您必須將此參數設置為 true。
    
    `useServerPrepStmts`：Newer versions of MySQL support server-side prepared statements, this can provide a substantial performance boost. Set this property to `true`.
    
    新版本的 MySQL 支持服務器端預備語句，這可以提供顯著的性能提升。將此屬性設置為 true。
    

範例：

- `application.yml` 設置

```yaml
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?serverTimezone=Asia/Shanghai
    username: root
    password: 123456
    hikari:
      auto-commit: true
      # connections = ((cpu 核心數 * 2) + 磁盤數量) 近似值。 默認 10
      maximum-pool-size: 10
      # 最小連接數，默認 10，不建議設置。默認與 maximum-pool-size 一樣大小。推薦使用固定大小的連接池
      minimum-idle: 10
      # 獲取連接時，檢測語句
      connection-test-query: select 1
      ###
      # 連接超時，默認 30 秒。
      # 控制客戶端在獲取池中 Connection 的等待時間，
      # 如過沒有連接可用情况下超過該時間，則拋出 SQLException 異常
      ###
      connection-timeout: 20000
      # 其他屬性
      data-source-properties:
        cachePrepStmts: true
        dataSource.cachePrepStmtst: true
        dataSource.prepStmtCacheSize: 250
        dataSource.prepStmtCacheSqlLimit: 2048
        dataSource.useServerPrepStmts: true
```

## 聲明式事務

- **為什麼需要事務?**
    
    事務是為了確保**數據操作的一致性和完整性**而引入的機制。當一個操作涉及到多個資源時，例如多個數據庫或多個文件系統，需要確保這些資源之間的操作具有原子性、一致性、隔離性和持久性。如果在操作過程中出現錯誤，事務管理機制可以**回滾操作**，從而保證資源之間的一致性。Spring 框架提供了聲明式事務管理，可以通過配置來實現事務管理，減少了編程式事務管理的代碼量和複雜度。
    

事務分為**全局事務**和**本地事務**，本地事務是特定於資源的，例如與 JDBC 連接關聯的事務。本地事務可能更容易使用，但有一個顯著的缺點：它們不能跨多個事務資源工作。比如在方法中處理連接多個 database 的事務，本地事務是無效的。

Spring 解決了全局和本地事務的缺點。它允許應用程序開發人員在任何環境中使用一致的編程模型。只需編寫一次代碼，就可以從不同環境中的不同事務管理策略中獲益。 Spring 框架同時提供聲明式和編程式事務管理。推薦聲明式事務管理。Spring 事務抽象的關鍵是事務策略的概念，`org.springframework.transaction.PlatformTransactionManager` 介面定義了事務的策略。

事務控制的屬性：

- Propagation : 傳播行為。代碼可以在現有事務中運行還是暫停現有事務並創建新事務。
- Isolation：隔離級別。此事務與其他事務的工作隔離的程度。例如，這個事務能看到其他事務未提交的寫嗎?
- Timeout 超時時間：該事務在超時和被底層事務基礎結構自動回滾之前運行的時間。
- Read-only 只讀狀態：當代碼讀取但不修改數據時，可以使用只讀事務。在某些情況下，例如使用 Hibernate時，只讀事務可能是一種有用的優化。

**AOP**：
Spring Framework 的聲明式事務管理是通過 Spring 面向方面編程（AOP）實現的。事務方面的代碼以樣板的方式使用，即使不了解 AOP 概念，仍然可以有效地使用這些代碼。事務使用 AOP 的環繞通知（TransactionInterceptor）。
聲明式事務的方式：

- **XML 配置文件**：全局配置
- `**@Transactional` 驅動** ：和代碼一起提供，比較直觀。和代碼的耦合比較高。
    
    Spring 團隊建議只使用 `@Transactional` 具體類(以及具體類的方法)，而不是註釋介面。
    
    當然，可以將 `@Transactional` 放在介面(或介面方法)上，但這只有在使用基於介面的代理時才能正常工作
    

方法的可見性：
`@Transactional` 應用 public 方法。因為如果使用 `@Transactional` 註解了 protected、private 或包可見的方法，則不會引發錯誤，但註釋的方法不會顯示配置的事務設置，事務不生效。如果需要受保護的、私有的方法具有事務考慮使用 AspectJ。而不是基於代理的機制。

範例：

- 創建 Entity

```java
@Data
public class ArticlePO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
```

```java
@Data
public class ArticleDetailPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
```

- 創建 mapper 介面

```java
public interface ArticleMapper {
    // 添加新的文章屬性 Article
    @Insert("""
            INSERT INTO article(user_id, title, summary, read_count, create_time, update_time)
            VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
            """)
    // 可選的配置，得到自動增長的主鍵值
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int insertArticle(ArticlePO article);

    // 添加文章內容 ArticleDetail
    @Insert("""
            INSERT INTO article_detail(article_id, content) 
            VALUES(#{articleId}, #{content})
            """)
    int insertArticleDetail(ArticleDetailPO detail);
}
```

- 創建 serivce & impl

```java
@Service
public class ArticleServiceImpl implements ArticleService {
    // 注入 mapper
    @Resource
    private ArticleMapper articleMapper;

    /**
     * @Transactional：事務控制註解
     * 位置：
     * 1. 方法上面
     * 2. class上面
     * 更推薦在方法上面使用，因為若在class上面，並不是所有的方法都需要事務控制
     * <p>
     * 事務回滾：
     * 1. 默認對運行異常時，執行回滾rollback
     * 2. rollbackFor：需要回滾的異常類列表
     */
    @Transactional(rollbackFor = {IOException.class})
    @Override
    public boolean postNewArticle(ArticlePO article, String content) {
        // 添加新的文章
        int rows = articleMapper.insertArticle(article);

        // 拋出異常
        if (article.getReadCount() < 1) {
            throw new RuntimeException("文章閱讀數量最小是1");
        }
        // 添加文章內容
        ArticleDetailPO detail = new ArticleDetailPO();
        detail.setArticleId(article.getId());
        detail.setContent(content);

        int detailRows = articleMapper.insertArticleDetail(detail);

        return (rows + detailRows) == 2;
    }

}
```

- 啟動類註解

```java
// 可選
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.transactional.mapper")
@SpringBootApplication
public class Lesson11TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson11TransactionalApplication.class, args);
	}

}
```

### 無效事務

1. Spring 框架的事務處理是透過 AOP 的環繞通知實現的。只有**透過代理物件調用具有事務的方法才能使事務生效**。例如，在一個 class 中，如果 A 方法調用了帶有事務的 B 方法，則調用 A 方法時事務將無效。需要注意的是，protected 和 private 方法默認是沒有事務功能的。
    
    範例：
    
    - service 中增加測試無效事務方法
    
    ```java
    @Service
    public class ArticleServiceImpl implements ArticleService {
    
        // 注入 mapper
        @Resource
        private ArticleMapper articleMapper;
    
        /**
         * @Transactional：事務控制註解 位置：
         * 1. 方法上面
         * 2. class上面
         * 更推薦在方法上面使用，因為若在class上面，並不是所有的方法都需要事務控制
         * <p>
         * 事務回滾：
         * 1. 默認對運行異常時，執行回滾rollback
         * 2. rollbackFor：需要回滾的異常類列表
         */
        @Transactional(rollbackFor = {IOException.class})
        @Override
        public boolean postNewArticle(ArticlePO article, String content) {
            // 添加新的文章
            int rows = articleMapper.insertArticle(article);
    
            // 拋出異常
            if (article.getReadCount() < 1) {
                throw new RuntimeException("文章閱讀數量最小是1");
            }
            // 添加文章內容
            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setArticleId(article.getId());
            detail.setContent(content);
    
            int detailRows = articleMapper.insertArticleDetail(detail);
    
            return (rows + detailRows) == 2;
        }
    
        @Override
        public boolean managerArticle(ArticlePO article, String content) {
            return postNewArticle(article, content);
        }
    
    }
    ```
    
    ```java
    System.out.println(articleService.getClass().getName());
    ```
    
2. 方法在執行緒中運行時，只有在同一執行緒中的方法才具有事務功能。如果代碼在新的執行緒中運行，則事務將無法生效。
    
    範例：
    
    ```java
    @Transactional
    @Override
    public boolean postNewArticleThread(ArticlePO article, String content) {
        System.out.println("Start 父線程：" + Thread.currentThread().threadId());
        Thread thread = new Thread(() -> {
            System.out.println("子線程：" + Thread.currentThread().threadId());
            // 新增文章
            articleMapper.insertArticle(article);
            // 拋出異常
            if (article.getReadCount() < 1) {
                throw new RuntimeException("文章閱讀數量最小是1");
            }
            // 添加文章內容
            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setArticleId(article.getId());
            detail.setContent(content);
            articleMapper.insertArticleDetail(detail);
        });
        // 線程啟動
        thread.start();
        try {
            // 等thread執行完成，再繼續後面的代碼
            thread.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End 父線程：" + Thread.currentThread().threadId());
        return true;
    }
    ```
    

### 事務回滾規則

以下是事務回滾的規則：

- 當方法拋出 RuntimeException 的實例或其子類時，事務將回滾。
- 當方法拋出 Error 時，事務也會回滾。
- 已檢查異常不會導致事務回滾，預設情況下會提交事務。

`@Transactional` 屬性可用於控制事務的回滾，包括：

- rollbackFor
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dac7735a-6473-4d47-8828-707860e5ef9f/Untitled.png)
    
- noRollbackFor
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/11fbf0e4-f264-430f-9db4-f7c25e6be402/Untitled.png)
    
- rollbackForClassName
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8bb785a7-3341-438a-8c76-f63ca492264c/Untitled.png)
    
- noRollbackForClassName
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/91af42d2-4d05-4193-9287-9a560c310652/Untitled.png)
