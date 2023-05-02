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
- # 字符表示注釋，只支持單行注釋。

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

ResultMap：結果映射，將查詢結果中的列和實體Bean的屬性對應關係。透過在xml文件使用<resultMap>標籤定義映射關係，例如：<select resultMap=”xxx”>

查詢操作得到包含多個列的集合，將列值轉為對象屬性使用結果映射的功能，註解@Results，@ResultMap能夠幫助我們完成此功能。
@Results 用於定義結果映射，每個列和 Java 對象屬性的一一對應。
@ResultMap 指定使用哪個結果映射，兩種方式可以使用@Results，另一種 XML 文件

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

1. 另一種方法在 xml 中定義<resultMap>標籤，在@ResultMap 註解引用。這種方式首先創建 xml。在 resources 目錄下創建自定義的 mapper 目錄。
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

  2. 修改 application.properties 配置 mapper 路徑

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

我們可以使用 Text Block 編寫長的 SQL 語句，而不是在方法中直接編寫 SQL。這樣做可以讓 SQL 更加簡潔易讀。

MyBatis 提供了 SQL 提供者的功能，將 SQL 以方法的形式定義在單獨的類中。通過引用 SQL 提供者中的方法名稱，Mapper 接口可以表示要執行的 SQL。

SQL 提供者有四類：@SelectProvider、@InsertProvider、@UpdateProvider 和 @DeleteProvider。SQLProvider首先創建提供者類，並聲明靜態方法，方法體是 SQL 語句並返回 SQL。例如：

```java
public static String selectById() {
	return "SELECT * FROM users WHERE id = #{id}";
}
```

其次，在 Mapper 接口的方法上面，使用 `@SelectProvider(type = 提供者類.class, method = "方法名稱")` 來應用對應的提供者類和方法名稱。

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
    // 定義@Results
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

### @One 一對一查詢

MyBatis 支持一對一，一對多，多對多查詢。 XML 文件和註解都能實現關係的操作。我們使用註解表示 article和 article_detail 的一對一關係。 MyBatis 維護這個關係， 開發人員自己也可以維護這種關係。

- @One：一對一
- @Many： 一對多

範例：

關係表一個 article 有一個article_detail 文章內容

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/14c90712-b04e-4466-a148-b75bd0bcccd9/Untitled.png)

- 創建Entity

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

### @Many 一對多查詢

一對一查詢使用 `@Many`，`步驟與一對一基本相同`

範例：

有一個comment表，article 與 comment 存在一對多關係，一篇文章多個評論

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1d5ae2d9-6bd7-491c-a1b8-7f2f400e8149/Untitled.png)

- 創建Entity

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

在 application 文件中，MyBatis 的設置屬性通常以`mybatis`開頭，全部設置可參考[官網](https://mybatis.org/mybatis-3/zh/configuration.html#settings)。

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

上述設置內容比較多時，可以將設置放到 MyBatis 主配置文件，mybatis.config-location 加載主配置文件。

- sql-config.xml

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

imports 文件中定義了 org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration 自動配置

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

SqlSessionTemplate 是線程安全的，MyBatis 為了與 Spring 繼承。提供的由 Spring 管理的 Bean。這個SqlSesionTemplate 實現了 SqlSession 接口， 能夠由 Spring 事務管理器使用。提供 Spring 的事務處理。同時管理SqlSession 的創建，銷毀。

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

- application.yml 設置

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


事務分為**全局事務**和**本地事務**，本地事務是特定於資源的，例如與 JDBC 連接關聯的事務。本地事務可能更容易使用，但有一個顯著的缺點：它們不能跨多個事務資源工作。比如在方法中處理連接多個數據庫的事務，本地事務是無效的。

Spring 解決了全局和本地事務的缺點。它允許應用程序開發人員在任何環境中使用一致的編程模型。只需編寫一次代碼，就可以從不同環境中的不同事務管理策略中獲益。 Spring 框架同時提供聲明式和編程式事務管理。推薦聲明式事務管理。Spring 事務抽象的關鍵是事務策略的概念，org.springframework.transaction.PlatformTransactionManager 介面定義了事務的策略。

事務控制的屬性：

- Propagation : 傳播行為。代碼可以在現有事務中運行還是暫停現有事務並創建新事務。
- Isolation：隔離級別。此事務與其他事務的工作隔離的程度。例如，這個事務能看到其他事務未提交的寫嗎?
- Timeout 超時時間：該事務在超時和被底層事務基礎結構自動回滾之前運行的時間。
- Read-only 只讀狀態：當代碼讀取但不修改數據時，可以使用只讀事務。在某些情況下，例如使用 Hibernate時，只讀事務可能是一種有用的優化。

AOP：
Spring Framework 的聲明式事務管理是通過 Spring 面向方面編程(AOP)實現的。事務方面的代碼以樣板的方式使用，即使不了解AOP 概念，仍然可以有效地使用這些代碼。事務使用AOP的環繞通知（TransactionInterceptor）。
聲明式事務的方式：

- XML 配置文件：全局配置
- @Transactional 註解驅動 ：和代碼一起提供，比較直觀。和代碼的耦合比較高。 【Spring 團隊建議您只使用@Transactional 註釋具體類(以及具體類的方法)，而不是註釋接口。當然，可以將@Transactional 註解放在接口(或接口方法)上，但這只有在使用基於接口的代理時才能正常工作】

方法的可見性：
@Transactional應用 public 方法。因為如果使用@Transactional 註解了 protected、private 或包可見的方法，則不會引發錯誤，但註釋的方法不會顯示配置的事務設置，事務不生效。如果需要受保護的、私有的方法具有事務考慮使用 AspectJ。而不是基於代理的機制。

範例：

- 創建Entity

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

1. Spring 框架的事務處理是透過 AOP 的環繞通知實現的。只有**透過代理對象調用具有事務的方法才能使事務生效**。例如，在一個 class 中，如果 A 方法調用了帶有事務的 B 方法，則調用 A 方法時事務將無效。需要注意的是，protected 和 private 方法默認是沒有事務功能的。

   範例：

  - service中增加測試無效事務方法

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


# Web 服務
基於瀏覽器的 B/S 結構應用非常流行，而 Spring Boot 非常適合 Web 應用開發。可以使用嵌入式 Tomcat、Jetty、Undertow 或 Netty 創建一個自包含的 HTTP 服務器，使 Spring Boot 的 Web 應用能夠自己獨立運行，不需要依賴安裝 Tomcat、Jetty 等其他服務器。

Spring Boot 可以創建兩種類型的 Web 應用：

- 基於 Servlet 體系的 Spring Web MVC 應用。
- 使用 `spring-boot-starter-webflux` 模塊來構建響應式、非阻塞的 Web 應用程序。

需要注意的是，[Spring WebFlux](https://openhome.cc/Gossip/Spring/WebFlux.html) 是一個單獨的體系。當前文檔講解的是 Spring Web MVC，也被稱為“Spring MVC”。Spring MVC 是一個“model view controller”的框架，專注於 Web 應用開發。我們可以快速創建控制器（Controller），接受來自瀏覽器或其他客戶端的請求，並將業務代碼的處理結果返回給請求方。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6c60a1fe-dea8-47a3-9fc2-d36d1d2841d7/Untitled.png)

## 高效構建 Web 應用

編寫 Spring MVC 的應用分成三步：

1. 編寫請求頁面（在瀏覽器直接模擬的請求）
2. 編寫 Controller
3. 編寫 view 頁面

範例：

- 編寫 Controller

```java
/**
 * @Controller：創建控制器object，控制器能夠接收request，並response給browser
 *              控制器也叫做處理器
 */
@Controller
public class QuickController {
    // 定義方法處理請求，方法叫做控制器方法(處理器方法)
    // Model表示模型，儲存數據。這個數據最後是放在request作用域
    // HttpServletRequest放在的作用域中
    @RequestMapping("/exam/quick")
    public String quick(Model model) {
        // 調用service，處理請求，獲取數據
        // 業務處理結果數據，放入到Model模型
        model.addAttribute("title", "web開發");
        model.addAttribute("time", LocalDateTime.now());

        // 指定視圖，顯示數據
        return "quick"; // -> 視圖文件的名稱
    }
}
```

- 編寫 view 頁面

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>view</title>
    </head>
    <body>
        <!-- 格式化，排列數據，view在browser顯示給用戶 -->
        <h3>顯示response處理結果</h3>
        <p th:text="${title}"></p>
        <p th:text="${time}"></p>
    </body>
</html>
```

- 訪問 [view](http://localhost:8080/exam/quick) 頁面

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6a8266df-7f72-4b40-9f85-91d9790b5072/Untitled.png)


### JSON View

上面的例子以 Html 文件作為視圖，可以編寫複雜的交互的頁面，CSS 美化數據。除了帶有頁面的數據，還有一種只需要數據的視圖。比如手機應用 app，app 的數據來自服務器應用處理結果。 app 內的數據顯示和服務器無關，只需要數據就可以了。主流方式是服務器返回 json 格式數據給手機 app 應用。我們可以通過原始的 HttpServletResponse 應該數據給請求方。借助 Spring MVC 能夠無感知的處理 json。

範例：

- 創建 Controller

```java
@Controller
public class JSONViewController {
    // 顯示json view，包含json數據
    @RequestMapping("/exam/json")
    public void responseJson(HttpServletResponse response) throws IOException {
        String json = "{\"name\":\"lisa\",\"age\":26}";
        // 應答，透過HttpServletResponse輸出
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

		/**
     * 接收請求的註解
     *
     * @GetMapping：接收get請求，簡化的@RequestMapping(method=RequestMethod.GET)
     * @PostMapping：接收post請求
     * @PutMapping：接收put請求
     * @DeleteMapping：接收delete請求
     */
    // @RequestMapping("/exam/user")
    @GetMapping("/exam/user")
    // SpringMVC 支持controller方法返回object，由框架將object使用jackson轉為json，並輸出
    // User --> 使用Jackson工具庫的ObjectMapper對象將user轉為 JSON 格式字符串 --> HttpServletResponse輸出
    @ResponseBody
    public User getUserJson() {
        User user = new User();
        user.setName("Susan");
        user.setAge("22");
        return user;
    }
}
```

Spring MVC 支持將 Controller 方法返回的物件轉換為 JSON 格式並輸出到客戶端。

框架使用 Jackson 工具庫的 ObjectMapper 對象將 Java 對象轉換為 JSON 格式字符串，然後使用 HttpServletResponse 將其輸出。

### 項目加上 favicon

favicon是網站的圖示，通常顯示在瀏覽器標籤上或書籤列表中，也稱為網站圖示、書籤圖示或網站標誌。它可以用來識別網站，增強品牌形象，提高用戶體驗。

favicon通常是一個小的圖像文件，格式可以是ICO、PNG、GIF等。瀏覽器會自動從網站的根目錄下尋找名為favicon.ico的檔案，如果找到了就會顯示在瀏覽器標籤上。如果沒有找到，瀏覽器就會顯示預設的圖示。

網站的favicon可以通過在HTML中使用link元素來指定，例如：

```html
<link rel="icon" href="favicon.ico" type="image/x-icon">
```

我們自己的網站定制 logo。首先找一個在線工具創建 favicon.ico。比如 [https://quanxin.org/favicon](https://quanxin.org/favicon) ， 用文字，圖片生成我們需要的內容。生成的 logo 文件名稱是 favicon.ico

範例：

- 將 favion 圖片貼到 resources → static資料夾裡面

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ed08543e-b1b5-447c-93ac-c8e0ec300842/Untitled.png)

- 編寫html文件，加入對 favicon.ico 的引用。
  在view的<head>部分加入`<link rel="icon" href="@{/favicon.ico}" type="image/x-icon"/>`

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>view</title>
        <link rel="icon" th:href="@{/tiger.ico}" type="image/x-icon"/>
<!--        <link rel="icon" href="../tiger.ico" type="image/x-icon"/>-->
    </head>
    <body>
        <!-- 格式化，排列數據，view在browser顯示給用戶 -->
        <h3>顯示response處理結果</h3>
        <p th:text="${title}"></p>
        <p th:text="${time}"></p>
    </body>
</html>/
```

這邊要注意的是

如果HTML檔案放在`/templates`資料夾下，而圖檔放在`/static`資料夾下，使用相對路徑 `../static/tiger.ico` 可能會找不到圖示。這是因為Thymeleaf模板引擎會將HTML檔案解析為動態模板，並動態生成HTML內容，因此相對路徑的參考點可能會發生變化。

為了確保能夠正確載入圖示，**建議使用Thymeleaf的`@{/}`表達式來生成相對路徑**。這樣可以保證相對路徑的參考點始終指向應用程式的根目錄，而不會受到動態模板的影響。

## Spring MVC

Spring MVC 是一個廣泛使用的 Web 應用框架，許多 Web 項目都採用它。它是 Spring 框架中的一個模組，專注於 Web 應用，可以使用 Spring 提供的強大功能，如 IoC、Aop 等等。Spring MVC 框架底層是基於 Servlet 技術，遵循 Servlet 規範，Web 組件 Servlet、Filter 和 Listener 在 Spring MVC 中都能使用。同時，Spring MVC 也是基於 MVC 架構模式的，職責分離，每個組件只負責自己的功能，組件解耦。要學習 Spring MVC，首先需要具備 Servlet 的知識，並了解 MVC 架構的 M、V、C 在 Spring MVC 框架中的實現。掌握這些知識後，就能熟練地開發 Web 應用。

Spring Boot 是一個能夠極大簡化 Web 應用開發的框架。它提供自動配置和按約定編程的功能，可以減少開發人員的工作量，提高開發效率。

## Controller 控制器

控制器是一種由 Spring 管理的 Bean 物件，其角色是處理請求。控制器可以接收瀏覽器發送過來的參數，處理數據並將 view視圖 應答給瀏覽器或客戶端 app 等。控制器是一個普通的 Bean，使用`**@Controller**` 或`**@RestController**` 註釋。`**@Controller**` 被聲明為 `**@Component**`，因此它也是一個 Bean 物件。



源代碼如下：

1. 有 `**@Controller**`、`**@RestController**` 注解的類叫做控制器，項目中控制器有很多一般相關的業務是一個控制器，如訂單的處理工作，訂單的控制 OrderController
2. `**@Controller**`、`**@RestController**` 區別
  - `**@RestController**` 包含了 `**@Controller**` 的功能，同時加入了 `**@ResponseBody**` 的註解，表示當前Controller中所有的方法，都會默認加入 `**@ResponseBody**` 的功能。方法的返回值是數據可以透過`HttpServletResponse`輸出給瀏覽器，請求方法

    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c201c5de-38b2-4d85-adc0-21538289347c/Untitled.png)

  - `**@Controller**`註解有 `**@Component**` 的功能，Controller 物件是Spring容器管理的。

    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/37d7c5cb-40bf-4f96-9e18-9ee71a574e61/Untitled.png)

3. 訂製 Controller 的方法
  1. 方法上面的`**@RequestMapping(value = “請求的uri地址”)**`：表示這個uri的請求由當前方法處理`**@GetMapping**`、`**@PostMapping**`、`**@PutMapping**`、`**@DeleteMapping**`
  2. Controller 方法的形參，接收請求的參數，多種方法接收參數
  3. Controller 方法的返回值，表示應答結果，給請求的結果(數據，view)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4bd341f0-4cf1-4dea-83fb-1062a2956569/Untitled.png)

### **匹配請求路徑到Controller方法**

SpringMVC 支持多種策略，匹配請求路徑到Controller方法。 AntPathMatcher 、 PathPatternParser

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f64a213a-ebbb-453f-9033-49ffec102a36/Untitled.png)

SpringBoot3 推薦使用 PathPatternParser 策略，比之前 AntPathMatcher 提示 6-8 倍吞吐量。
PathPatternParser 中有關 uri 的定義

通配符：

- ? ：一個字符

    ```java
    /**
     * ？ 匹配只有一個字符
     * o -> GET http://localhost:8080/file/test.html
     * x -> GET http://localhost:8080/file/teest.html
     */
    @GetMapping("/file/t?st.html")
    public String path1(HttpServletRequest request) {
        return "path 請求 = " + request.getRequestURI();
    }
    ```

- *：0 或多個字符。在一個路徑段中匹配字符

    ```java
    /**
     * *：匹配一個路徑段中的 0 或多個字符
     * o -> GET http://localhost:8080/images/user.gif
     * o -> GET http://localhost:8080/images/cat.gif
     * o -> GET http://localhost:8080/images/.gif
     * x -> GET http://localhost:8080/images/gif/header.gif
     * x -> GET http://localhost:8080/images/dog.jpg
     */
    @GetMapping("images/*.gif")
    public String path2(HttpServletRequest request) {
        return "* 請求 = " + request.getRequestURI();
    }
    ```

- **：匹配 0 個或多個路徑段，相當於是所有

    ```java
    /**
     * ** 匹配 0 或多段路徑， 匹配/pic 開始的所有請求
     * o -> GET http://localhost:8080/pic/p1.gif
     * o -> GET http://localhost:8080/pic/20222/p1.gif
     * o -> GET http://localhost:8080/pic/user
     * o -> GET http://localhost:8080/pic/
     */
    @GetMapping("pic/**")
    public String path3(HttpServletRequest request) {
        return "/pic/** 請求 = " + request.getRequestURI();
    }
    ```

- 正則表達式：支持正則表達式

    ```java
    /**
     * fname是自定義路徑變量名稱
     * : 後面是正則匹配
     * :\\w+ 正則匹配， xxx.log
     * w 表示字符
     * + 代表最少一個
     * o -> GET http://localhost:8080/pages/req.log
     * o -> GET http://localhost:8080/pages/111.log
     * x -> GET http://localhost:8080/pages/req.txt
     * x -> GET http://localhost:8080/pages/###.log
     *
     */
    @GetMapping("/pages/{fname:\\w+}.log")
    public String path5(@PathVariable("fname") String filename, HttpServletRequest request) {
        return "/pages/{fname:\\w+}.log 請求 = " + request.getRequestURI() + ", filename = " + filename;
    }
    ```


RESTFul 的支持路徑變量

- { 變量名 }

    ```java
    /**
     * {*id} 匹配 /order 開始的所有請求， id 表示 order 後面直到路徑末尾的所有内容。
     * id 自定義路徑變量名稱。與 @PathVariable 一樣使用
     * o -> GET http://localhost:8080/order/1001
     * o -> GET http://localhost:8080/order/1001/2023-02-16
     * 注意：@GetMapping("/order/{*id}/{*date}") 是無效的， {*..}後面不能再有匹配規則了
     */
    @GetMapping("order/{*id}")
    public String path4(@PathVariable("id") String orderId, HttpServletRequest request) {
        return "order/{*id} 請求 = " + request.getRequestURI() + ", id = " + orderId;
    }
    ```

- { myname:[a-z]+ }: 正則皮 a-z 的多個字面，路徑變量名稱“myname”。 PathVariable(“myname”)
- { *myname }: 匹配多個路徑一直到 uri 的結尾

範例：

```java
@RestController
public class ExamplePathController {
    /**
     * ？匹配只有一個字符
     * o -> GET http://localhost:8080/file/test.html
     * x -> GET http://localhost:8080/file/teest.html
     */
    @GetMapping("/file/t?st.html")
    public String path1(HttpServletRequest request) {
        return "path 請求 = " + request.getRequestURI();
    }

    /**
     * *：匹配一個路徑段中的 0 或多個字符
     * o -> GET http://localhost:8080/images/user.gif
     * o -> GET http://localhost:8080/images/cat.gif
     * o -> GET http://localhost:8080/images/.gif
     * x -> GET http://localhost:8080/images/gif/header.gif
     * x -> GET http://localhost:8080/images/dog.jpg
     */
    @GetMapping("images/*.gif")
    public String path2(HttpServletRequest request) {
        return "* 請求 = " + request.getRequestURI();
    }

    /**
     * ** 匹配 0 或多段路徑， 匹配/pic 開始的所有請求
     * o -> GET http://localhost:8080/pic/p1.gif
     * o -> GET http://localhost:8080/pic/20222/p1.gif
     * o -> GET http://localhost:8080/pic/user
     * o -> GET http://localhost:8080/pic/
     */
    @GetMapping("pic/**")
    public String path3(HttpServletRequest request) {
        return "/pic/** 請求 = " + request.getRequestURI();
    }

		/**
     * {*id} 匹配 /order 開始的所有請求， id 表示 order 後面直到路徑末尾的所有内容。
     * id 自定義路徑變量名稱。與 @PathVariable 一樣使用
     * o -> GET http://localhost:8080/order/1001
     * o -> GET http://localhost:8080/order/1001/2023-02-16
     * 注意：@GetMapping("/order/{*id}/{*date}") 是無效的， {*..}後面不能再有匹配規則了
     */
    @GetMapping("order/{*id}")
    public String path4(@PathVariable("id") String orderId, HttpServletRequest request) {
        return "order/{*id} 請求 = " + request.getRequestURI() + ", id = " + orderId;
    }

		/**
     * fname是自定義路徑變量名稱
     * : 後面是正則匹配
     * :\\w+ 正則匹配， xxx.log
     * w 表示字符
     * + 代表最少一個
     * o -> GET http://localhost:8080/pages/req.log
     * o -> GET http://localhost:8080/pages/111.log
     * x -> GET http://localhost:8080/pages/req.txt
     * x -> GET http://localhost:8080/pages/###.log
     *
     */
    @GetMapping("/pages/{fname:\\w+}.log")
    public String path5(@PathVariable("fname") String filename, HttpServletRequest request) {
        return "/pages/{fname:\\w+}.log 請求 = " + request.getRequestURI() + ", filename = " + filename;
    }

}
```

### @RequestMapping

`**@RequestMapping**`：用於將 web 請求映射到Controller class的方法。此方法處理請求。可用在class上或方法上。在class和方法同時組合使用。
重要的屬性：

- value：別名 path 表示請求的 uri， 在class和方法方法同時使用 value，方法上的繼承class上的 value 值。
- method：請求方式，支持 GET, POST, HEAD, OPTIONS, PUT, PATCH, DELETE, TRACE。
  值為：RequestMethod[] method() ， RequestMethod 是 enum 類型。

快捷註解：

- `**@GetMapping**`：表示 get 請求方式的@RequestMapping
- `**@PostMapping**`：表示 post 請求方式的@RequestMapping
  - 在使用 Spring 的 **`@PostMapping`** 接收參數時，如果沒有使用 **`@RequestBody`** 注解，Spring 會默認將參數解析為***表單參數***，而不是解析為請求體中的 JSON 或 XML 等格式數據。
    - 表單參數（Form Parameter）是通過 HTML 表單提交到服務器的數據。
      - 在 HTTP 請求中，表單參數可以作為請求體（Request Body）的一部分發送到服務器。
      - 表單參數通常由 HTML 表單的輸入控件（如文本框、下拉框、單選框等）和提交按鈕組成，當用戶點擊提交按鈕時，瀏覽器會將表單參數編碼為 URL 查詢字符串或者 MIME 類型為 **`application/x-www-form-urlencoded`** 的請求體，然後將它們發送到服務器。
      - 這些表單參數的類型通常是String或Java基本型別，例如Integer、Double等等，通常使用 `**@RequestParam**` 來標註
  - 如果在 Postman 中發送請求時沒有設置請求的 Content-Type 為 **`application/json`** 或 **`application/xml`** 等支持的格式，那麼服務器端就無法正確地解析請求體中的參數數據，導致無法接收到數據。
  - 如果想要在服務器端使用 **`@PostMapping`** 接收請求體中的 JSON 或 XML 格式的參數數據，需要同時使用 **`@RequestBody`** 註解，以告知 Spring 將請求體中的數據解析為對應的 Java 物件。同時，在 Postman 中發送請求時需要設置請求的 Content-Type 為對應的格式。
- `**@PutMapping**`：表示 put 請求方式的@RequestMapping
- `@DeleteMapping`：表示 delete 請求方式的@RequestMapping

對於請求方式 get，post，put，delete 等，能夠 HttpMethod 表示

- Spring Boot3 之前 → enum

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fc057623-a909-4f78-a4a6-f879ad73a670/Untitled.png)

- Spring Boot3 現在 → final class

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5e93398e-ffd0-4451-afca-85b9596fa591/Untitled.png)

### 控制器方法參數類型與可用返回值類型

參數類型

| 類型 | 作用 |
| --- | --- |
| WebRequest, NativeWebRequest | 訪問請求參數，作用同 ServletRequest |
| jakarta.servlet.ServletRequest, 
jakarta.servlet.ServletResponse | Servlet API 中的請求，應答 |
| jakarta.servlet.http.HttpSession | Servlet API 的會話 |
| jakarta.servlet.http.PushBuilder | Servlet 4.0 規範中推送對象 |
| HttpMethod | 請求方式 |
| java.io.InputStream, java.io.Reader | IO 中輸入，讀取 request body |
| java.io.OutputStream, java.io.Writer | IO 中輸入，訪問 response body |
| @PathVariable，@MatrixVariable，RequestParam，
@RequestHeader，@CookieValue，RequestBody，
@RequestPart，@ModelAttribute | uri 模板中的變量，訪問矩陣，訪問單個請求參數，訪問，請求 header，訪問 cookie，讀取請求 body， 文件上傳，訪問 model 中屬性 |
| Errors, BindingResult | 錯誤和綁定結果 |
| java.util.Map
org.springframework.ui.Model
org.springframework.ui.ModelMap | 存儲數據 Map，Model，ModelMap |
| 其他參數 | String name, Integer , 自定義對象 |

> 更多參數類型可以參考[官網](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments)
>

返回值：

| 返回值類型 | 作用 |
| --- | --- |
| @ResponseBody | 將 response body 屬性序列化輸出 |
| HttpEntity<B>, ResponseEntity<B> | 包含 http 狀態碼和數據的實體 |
| String | 實體名稱或字符串數據 |
| 自定義物件 | 如果有 json 庫，序列化為 json 字符串 |
| ErrorResponse | 錯誤物件 |
| ProblemDetail | RFC7807，規範的錯誤應答物件 |
| void | 無返回值 |
| ModelAndView | 數據和視圖 |
| java.util.Map, org.springframework.ui.Model | 作為模型的數據 |

> 更多返回值可以參考[官網](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types)
>

### 接收請求參數

當用戶在瀏覽器中點擊按鈕時，會向服務器發送一個請求，其中包含了讓服務器程序需要做什麼的參數。這些參數會被發送到 Controller 方法中作為形參列表的一部分。
Controller 方法可以使用多種方式來接受這些參數：

- 當請求參數與形參一一對應時，可以使用合適的數據類型（如 String、Integer、int 等）來接受簡單類型的參數。

    ```java
    // 一一對應，適合接收簡單類型數據，如：String、int、long、double、float，參數量比較少
    @GetMapping("/param/p1")
    public String p1(String name, Integer age, String sex) {
        return "接收參數: " + name + "," + age + "," + sex;
    }
    ```

- 當參數是物件類型時，Controller 方法的形參可以是物件，並且請求的多個參數名與屬性名相對應。

    ```java
    // 使用物件接收參數，要求物件的屬性名稱和請求中的參數名一樣，屬性有set方法，class有無參數構造方法
    @GetMapping("/param/p2")
    public String p2(Person person, String type) {
        return "接收參數, 使用物件: " + person.toString();
    }
    ```

- 使用 HttpServletRequest 物件，可以使用 `request.getParameter("...")` 方法來接收參數。

    ```java
    // 使用 HttpServletRequest 接收參數
    @GetMapping("/param/p3")
    public String p3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        return "name = " + name + ", age = " + age + ", sex = " + sex;
    }
    ```

- 使用 `**@RequestParam**` 註解，可以將查詢參數、表單數據或 multipart 文件解析到方法參數中。
  - 可以指定參數的名稱、是否必填、默認值等等
  - 只能接收基本型別的參數，例如：Integer、Double 等等，不能是物件
  - 通常用於處理GET請求的URL中的參數。當使用 `**@RequestParam**` 時，Spring Boot會自動將URL中的參數轉換為對應的Java類型，例如String、Integer等等。
  - 預設的 Content-Type 是 `**application/x-www-form-urlencoded**`，所以當你使用 @RequestParam 時，如果沒有特別指定 Content-Type，就會使用預設值，所以在傳送請求時不需要額外指定Content-Type。

    ```java
    // 使用 RequestParam
    // 不加 也能接收，加了 強制由框架解析參數
    @GetMapping("/param/p4")
    public String p4(@RequestParam(value = "name", required = true) String name,
                     @RequestParam(value = "age", required = false, defaultValue = "24") Integer age) {
        return "p4, name = " + name + ", age = " + age;
    }
    ```

- 使用 `**@RequestBody**` 註解，可以接收前端傳遞的 JSON 格式參數。
  - 可以將請求體轉換為Java物件
  - 使用 `**@RequestBody**` 時，Spring Boot預設使用內置的 HttpMessageConverter 來處理請求體，並將其轉換為Java物件。也可以自定義 HttpMessageConverter 來處理不同類型的請求體
  - 只能處理請求體，無法處理URL上的參數
  - 通常用於處理POST請求中的JSON格式的請求體。在這種情況下，請求體中的JSON格式的數據會被轉換為Java物件，方便開發者進行處理。
  - 需要注意的是，當使用 `**@RequestBody**` 處理JSON格式的請求體時，需要指定Content-Type為`**application/json**`。
- 使用 `**@RequestHeader**` 註解，可以從請求 header 中獲取某項值。

Spring MVC 提供了一個 **HandlerMethodArgumentResolver** 介面來解析這些參數。這個介面可以幫助 Controller 方法解析請求並獲取參數的值。

### 接收 json

範例：

- 使用 `**@RequestBody**` 註解，可以接收前端傳遞的 JSON 格式參數。

    ```java
    // 使用 RequestBody 接收 json，post請求體數據
    /**
     * 前端數據： { "username":"lisa", "age":20 }
     * @RequestBody： 從請求體中讀取 json 數據，將數據轉為形參對象的屬性值
     *                框架創建 User物件，將 username、age key的值賦值給兩個同名的屬性
     * 前端請求中需要指定：頭 Content-Type：application/json
     */
    @PostMapping("/param/json")
    public String p6(@RequestBody User user) {
        System.out.println("接收的 json：" + user.toString());
        return "p6, json 轉為 User物件：" + user;
    }
    ```


**Reader-InputStream**

使用 Reader 或 InputStream 讀取網頁請求體的數據，這種方式適用於處理 POST 請求體中的各種數據，包括二進制數據。這種方式相對靈活，可以處理多種類型的數據。但是，使用這種方式需要手動進行數據解析，並且相對較為繁瑣。

在實際開發中，通常會使用 Spring MVC 框架提供的請求參數解析器來簡化這個過程。

範例：

```java
// 使用 Reader-InputStream 讀取 post 請求體數據
@PostMapping("/param/json2")
public String p7(Reader reader) {
    StringBuilder content = new StringBuilder();
    try (BufferedReader bin = new BufferedReader(reader)) {
        String line;
        while ((line = bin.readLine()) != null) {
            content.append(line);
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    return "p7, reader = " + content;
}
```

**數組參數接收多個值**

數組作為 Controller 方法形參，可以接受多個請求參數值。這種方式通常用於處理請求格式為「參數名=值1&參數名=值2...」的情況。

在 Controller 方法中，可以使用數組來接收這些參數值，並對其進行後續處理。使用這種方式可以簡化請求參數的處理過程，使代碼更加簡潔易讀。

範例：

```java
// 接收數組 多個值
@GetMapping("/param/vals")
public String getMultiVal(Integer[] id) {
    List<Integer> idList = Arrays.stream(id).toList();
    return idList.toString();
}
```

### BeanValidation 驗證參數

在服務器端程序中，Controller 接收到用戶提供的參數後，需要對這些參數進行校驗。校驗的目的是確保參數的值在允許的範圍內，且符合業務要求。例如，年齡不能 < 0，姓名不能為空字符串，email 必須包含@符號，手機號碼必須是10位數字。

參數校驗：

1. 可以手動編寫代碼進行驗證，主要使用 if 語句、switch 等邏輯結構。
2. 也可以使用 Java Bean Validation 進行校驗。 JSR-303 是 JAVA EE 6 中的一項子規範，叫做 Bean Validation，是一個運行時的數據驗證規範。它為 JavaBean 驗證定義了相應的元數據模型和 API。

**Java Bean Validation**

Spring Boot 可以使用 Java Bean Validation 對領域模型的屬性值進行驗證，以確保其符合預期。如果驗證失敗，將立即返回錯誤信息。 Java Bean Validation 將驗證規則從 controller 和 service 集中到 Bean 對象，實現了一處控制所有驗證的功能。

要實現驗證規則的定義，只需要在 Bean 的屬性上添加 JSR-303 的註解即可。 JSR-303 是規範，而 hibernate-validator 則是其實現。
JSR-303：[https://beanvalidation.org/](https://beanvalidation.org/)

hibernate-validator文檔內容：

- [https://hibernate.org/validator/](https://hibernate.org/validator/)
- [https://docs.jboss.org/hibernate/validator/4.2/reference/en-US/html/](https://docs.jboss.org/hibernate/validator/4.2/reference/en-US/html/)

**JSR-303 注解**

JSR-303 定義的常用的 annotation：

| annotation | effect |
| --- | --- |
| @Null | 被註釋的元素必須為 null |
| @NotNull | 被註釋的元素必須不為 null |
| @AssertTrue | 被註釋的元素必須為 true |
| @AssertFalse |  被註釋的元素必須為 false |
| @Min(value) | 被註釋的元素必須是一個數字，其值必須 ≥ value |
| @Max(value) | 被註釋的元素必須是一個數字，其值必須 ≤ value |
| @DecimalMin(value)  | 被註釋的元素必須是一個數字，其值必須 ≥ value |
| @DecimalMax(value) | 被註釋的元素必須是一個數字，其值必須 ≤ value |
| @Size(max, min) | 被註釋的元素的大小必須在指定的範圍內 |
| @Digits (integer, fraction) | 被註釋的元素必須是一個數字，其值必須在可接受的範圍內 |
| @Past | 被註釋的元素必須是一個過去的日期 |
| @Future | 被註釋的元素必須是一個將來的日期 |
| @Pattern(value) | 被註釋的元素必須符合指定的正則表達式 |
| @Email | 被註釋的元素必須是電子郵箱地址 |
| @NotEmpty | 被註釋的字符串的必須非空 |

Hibernate 提供的部分 annotation：

| annotation | effect |
| --- | --- |
| @URL | 被註釋的字符為 URL |
| @Length | 被註釋的字符串的大小必須在指定的範圍內 |
| @Range | 被註釋的元素必須在合適的範圍內 |

範例：

- 需添加依賴

    ```xml
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```

- 創建 Bean，添加約束annotation

    ```java
    @Data
    public class ArticleVO {
        // 文章主鍵
        private Integer id;
    
        @NotNull(message = "必須有作者")
        private Integer userId;
    
        // 同一個屬性可以指定多個annotation
        @NotBlank(message = "文章必須有標題")
        // @Size 中 null 認為是有效值，所以需要 @NotBlank
        @Size(min = 3, max = 30, message = "標題必須3個字以上")
        private String title;
    
        @NotBlank(message = "文章必須有副標題")
        @Size(min = 5, max = 60, message = "副標題必須5個字以上")
        private String summary;
    
        @DecimalMin(value = "0", message = "閱讀數量不能小於0")
        private Integer readCount;
    
        @Email(message = "信箱格式不正確")
        private String email;
    }
    ```

- 建立 Controller ，使用 Bean

    ```java
    @RestController
    public class ArticleController {
        /**
         * @Validated：驗證Bean BindingResult： 包含Bean的驗證結果
         */
        @PostMapping("article/add")
        public Map<String, String> addArticle(@Validated @RequestBody ArticleVO vo, BindingResult result) {
            Map<String, String> errors = new HashMap<>();
            if (result.hasErrors()) {
                int errorIndex = 0;
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.put(errorIndex + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                    errorIndex++;
                }
            }
            return errors;
        }
    }
    ```


**分組校驗**

上面的ArticleVO類用於新增文章，其中新文章的主鍵id是系統生成的。現在需要修改文章，例如修改某篇文章的title、summary、readCount、email等。此時id必須有值，以修改該id對應的文章。新增和修改操作對id有不同的約束要求。通過 group 來區分是否驗證。

group 是用Class表示的，在Java中，包加類一定是唯一的，這個標識沒有其他實際意義。

範例：

- 添加 group 標誌

    ```java
    @Data
    public class ArticleVO {
        // group 就是 介面名
        public interface AddArticleGroup {}
        public interface EditArticleGroup {}
    
        // 文章主鍵
        @NotNull(message = "文章 id 不能為空", groups = {EditArticleGroup.class})
        @Min(value = 1, message = "文章 id 從 1 開始", groups = {EditArticleGroup.class})
        private Integer id;
    
        @NotNull(message = "必須有作者", groups = {AddArticleGroup.class, EditArticleGroup.class})
        private Integer userId;
    
        // 同一個屬性可以指定多個annotation
        @NotBlank(message = "文章必須有標題", groups = {AddArticleGroup.class, EditArticleGroup.class})
        // @Size 中 null 認為是有效值，所以需要 @NotBlank
        @Size(min = 3, max = 30, message = "標題必須3個字以上", groups = {AddArticleGroup.class, EditArticleGroup.class})
        private String title;
    
        @NotBlank(message = "文章必須有副標題", groups = {AddArticleGroup.class, EditArticleGroup.class})
        @Size(min = 5, max = 60, message = "副標題必須5個字以上", groups = {AddArticleGroup.class, EditArticleGroup.class})
        private String summary;
    
        @DecimalMin(value = "0", message = "閱讀數量不能小於0", groups = {AddArticleGroup.class, EditArticleGroup.class})
        private Integer readCount;
    
        @Email(message = "信箱格式不正確", groups = {AddArticleGroup.class, EditArticleGroup.class})
        private String email;
    }
    ```

- Controller 添加方法

    ```java
    @RestController
    public class ArticleController {
        /**
         * @Validated：驗證Bean BindingResult： 包含Bean的驗證結果
         */
        @PostMapping("article/add")
        public Map<String, String> addArticle(@Validated(ArticleVO.AddArticleGroup.class) @RequestBody ArticleVO vo, BindingResult result) {
            Map<String, String> errors = new HashMap<>();
            if (result.hasErrors()) {
                int errorIndex = 0;
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.put(errorIndex + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                    errorIndex++;
                }
            }
            return errors;
        }
    
        @PostMapping("article/edit")
        public Map<String, String> editArticle(@Validated(ArticleVO.EditArticleGroup.class) @RequestBody ArticleVO vo, BindingResult result) {
            Map<String, String> errors = new HashMap<>();
            if (result.hasErrors()) {
                int errorIndex = 0;
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.put(errorIndex + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                    errorIndex++;
                }
            }
            return errors;
        }
    }
    ```


**ValidationAutoConfiguration**

Spring Boot的`spring-boot-starter-validation`引入了`jakarta.validation:jakarta.validation-api:3.0.2`約束接口，以及`org.hibernate.validator:hibernate-validator:8.0.0.Final`約束註解的功能實現。

透過`ValidationAutoConfiguration`自動配置類，可以創建一個`LocalValidatorFactoryBean`物件，並將其註冊到Spring應用上下文中。當在class路徑中發現了`hibernate.validator`時，就能夠創建Hibernate的約束驗證實現物件。

此外，`@ConditionalOnResource(resources = "classpath:META-INF/services/jakarta.validation.spi.ValidationProvider")`條件判斷會檢查是否存在Jakarta Validation Provider服務提供者配置文件，以確保ValidationAutoConfiguration只有在存在Jakarta Validation Provider時才會啟用。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5c01698f-063a-4f9c-a856-5b35124e8194/Untitled.png)

## Model 模型

在許多實際項目需求中，後端應用程式需要直接將前端需要的資料返回給控制層，這時Model大家族就派上用場了。

Model模型的意思，在Spring MVC中的"M"，用來傳輸資料。透過設定JSP或模板技術，可以將Model中存儲的資料展示給前端。

簡單來說，Model就是用來存放要提供給前端瀏覽器的資料。在`ModelAndView`中，任何值都可以是Model，而JSON格式的字串也可以是Model。

範例：

```java
/**
 * @Controller：創建控制器object，控制器能夠接收request，並response給browser
 *              控制器也叫做處理器
 */
@Controller
public class QuickController {
    // 定義方法處理請求，方法叫做控制器方法(處理器方法)
    // Model表示模型，儲存數據。這個數據最後是放在request作用域
    // HttpServletRequest放在的作用域中
    @RequestMapping("/exam/quick")
    public String quick(Model model) {
        // 調用service，處理請求，獲取數據
        // 業務處理結果數據，放入到Model模型
        model.addAttribute("title", "web開發");
        model.addAttribute("time", LocalDateTime.now());

        // 指定視圖，顯示數據
        return "quick"; // -> 視圖文件的名稱
    }
}
```

## View 視圖

Spring MVC中的 View（視圖）用於展示資料，而視圖技術的使用是可插拔的。無論決定使用Thymeleaf、JSP或其他技術，只要classpath中有jar，就可以使用視圖了。在Spring Boot 3中，不再推薦使用FreeMarker、JSP等技術，而是推薦使用 Thymeleaf 或 Groovy Templates。`org.springframework.web.servlet.View`是視圖的介面，而實現此介面的都是視圖類，這些視圖類作為Bean由Spring管理。當然，這些都不需要開發者編寫代碼。

常用的視圖類有：

- `ThymeleafView`：使用Thymeleaf視圖技術時的視圖類
- `InternalResourceView`：表示JSP的視圖類

控制器方法的返回值和視圖有關：

- 如果專案中有Thymeleaf，則返回值為String表示xxx.html視圖文件（/resources目錄）
- 如果返回值為ModelAndView，則View就是表示視圖。

而`@ResponseBody`和`@RestController`適合前後端分離項目：

- 常用的返回值有String（表示一個字符串資料）
- Object（如果有Jackson庫，將Object轉為JSON字串）和ResponseEntity。

常用的返回值：

- String
- 自定義 Object
- ResponseEntity

### 頁面視圖

Thymeleaf 作為代替 jsp 的視圖技術，可以編寫頁面，排列數據。

範例：

- 建立 Controller

```java
@GetMapping("/hello")
public ModelAndView hello(Model model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("name", "Lisa");
    modelAndView.addObject("age", 20);
    modelAndView.setViewName("hello");
    return modelAndView;
}
```

- 建立 html 文件

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <p th:text="${name}"></p>
        <p th:text="${age}"></p>
    </body>
</html>
```

application.yml 默認 thymeleaf 的設置

```yaml
spring:
  thymeleaf:
    # 後綴 仕途文件擴展名
    suffix: .html
    # 前綴 視圖文件存放位置
    prefix: classpath:/templates/
```

### JSON 視圖

範例：

```java
@GetMapping("/exam/user")
// SpringMVC 支持controller方法返回object，由框架將object使用jackson轉為json，並輸出
// User --> 使用Jackson工具庫的ObjectMapper對象將user轉為 JSON 格式字符串 --> HttpServletResponse輸出
@ResponseBody
public User getUserJson() {
    User user = new User();
    user.setName("Susan");
    user.setAge("22");
    return user;
}
```

### 複雜 JSON

在一個類中定義其他多個引用類型，或集合類型。構成複雜 json

- 建立 Bean

    ```java
    @Data
    public class Role {
        //角色 ID
        private Integer id;
        //角色名稱
        private String roleName;
        //角色說明
        private String memo;
    }
    ```

    ```java
    @Data
    public class User {
        private String name;
        private String age;
        private Role role;
    }
    ```

- 建立 Controller

    ```java
    @GetMapping("/show/json")
    @ResponseBody
    public User getUserRole() {
        User user = new User();
        user.setName("Lisa");
        user.setAge(26);
        Role role = new Role();
        role.setId(5892);
        role.setRoleName("管理員");
        role.setMemo("具有較高的權限");
        user.setRole(role);
        return user;
    }
    ```


### ResponseEntity 自定義StatusCode

`ResponseEntity`是一種包含HTTP狀態碼和回應資料的結合體。由於HTTP狀態碼可以表達標準的語義，例如200表示成功，404表示未找到等，因此在Restful API中使用`ResponseEntity`非常方便。

範例：

- ResponseEntity 作為返回值

    ```java
    @GetMapping("/show/json3")
    @ResponseBody
    public ResponseEntity<User> returnEntity() {
        User user = new User();
        user.setName("Lisa");
        user.setAge(26);
        Role role = new Role();
        role.setId(5892);
        role.setRoleName("管理員");
        role.setMemo("具有較高的權限");
        user.setRole(role);
        ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        return response;
    }
    ```


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e8171030-2fc7-47e3-bca2-11f2297724e2/Untitled.png)

### Map 作為返回值

Map 作為返回值是數據，能夠自動轉為 json

範例：

- 創建 Controller 方法

    ```java
    @GetMapping("/map/json")
    @ResponseBody public Map getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1001);
        map.put("address","信義區");
        map.put("city","台北");
        return map;
    }
    ```


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2b681a72-c611-4bc5-a448-8c52c4c47025/Untitled.png)

# SpringMVC 請求流程

Spring MVC 框架是基於 Servlet 技術構建的，使用請求-響應模型來處理用戶的請求。它圍繞著 Servlet 的設計而建立，並以請求為驅動。

當用戶發送請求時，Spring MVC 會將其轉發至對應的 Servlet 進行處理，並執行 doService 方法。此方法會根據請求的內容進行相應的處理，最終生成響應結果並返回給瀏覽器，完成一次請求處理過程。

## DispatcherServlet

DispatcherServlet 是 SpringMVC 中的核心對象，也被稱為中央調度器（前端控制器 Front Controller）。它的主要職責是接收所有針對 Controller 的請求，並調用開發者編寫的 Controller 處理業務邏輯。最終，DispatcherServlet 會將 Controller 方法的返回值經過視圖處理後響應給瀏覽器。

在 SpringMVC 中，DispatcherServlet 扮演著 C 的角色，具體職責如下：

1. 作為門面接收請求並控制請求的處理過程。所有請求都必須經過 DispatcherServlet 進行控制，因此它是 SpringMVC 對外的入口。可以將其看作門面設計模式的實現。
2. 訪問其他的 Conroller，這些控制器負責處理業務邏輯。
3. 創建合適的 View，將 Controller 處理得到的業務結果放到 View 中，並將 View 響應給用戶。
4. 解耦了其他組件，所有組件只與 DispatcherServlet 進行交互，彼此之間沒有關聯。
5. DispatcherServlet繼承ApplicationContextAware代表可以取得應用程式上下文(Application Context)並將其設置為其成員變數。
  - 每個DispatcherServlet都有自己的WebApplicationContext，它也繼承了ApplicationContext。
  - WebApplicationContext包含了Web相關的Bean物件，例如使用開發人員註釋`@Controller`的類別、視圖解析器、視圖物件等等，DispatcherServlet可以存取這些Bean物件。
  - 這使得DispatcherServlet能夠使用應用程式上下文中的Bean物件，例如控制器(Controller)、服務(Service)等等。
  - 因此，繼承ApplicationContextAware與Spring容器有關，它允許DispatcherServlet在執行時與Spring容器進行交互，以便更好地管理應用程式中的Bean物件。
  - 上下文 (context)

    在Spring框架中，上下文（Context）指的是Spring容器所管理的所有bean以及它們之間的相互關係。Spring容器在啟動時會創建一個應用程序上下文(Application Context)，並根據配置文件中的設置來實例化和配置bean。上下文提供了一個環境，使得應用程序中的bean能夠互相協作，以實現應用程序的功能。

6. 結合 Servlet 和 Spring IoC 容器，實現了對 Web 應用程序的控制。

需要注意的是，DispatcherServlet 是 SpringMVC 中的核心組件，對於開發者而言，了解其職責和作用非常重要。

![1. 繼承 HttpServlet → DispatcherServlet 是一個 Servlet
2. 繼承 ApplicationContextAware → 能夠使用應用程序中的上下文(context)](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0ab414d5-c30b-42d3-b7e7-4382b8d00b72/Untitled.png)

1. 繼承 HttpServlet → DispatcherServlet 是一個 Servlet
2. 繼承 ApplicationContextAware → 能夠使用應用程序中的上下文(context)

## Spring MVC 的完整請求流程

- 講的好複雜QQ，碰到再回來聽

  [127-Web-静态代码分析_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1Km4y1k7bn/?p=127&spm_id_from=pageDriver&vd_source=17a419b1be9464b814a7f629e6a3f5c0)


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/72c964a5-d6e7-42e8-8184-447538f863f2/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/942ecd35-b468-4b61-a508-67b731e55604/Untitled.png)

1. 紅色 DispatherServlet 是框架創建的核心對象（可配置它的屬性 contextPath）
2. 藍色的部分框架已經提供多個對象。開發人員可自定義，替換默認的對象。
3. 綠色的部分是開發人員自己創建的對象，控制器 Conroller

流程說明：

1. DispatcherServlet 接收到客戶端發送的請求。判斷是普通請求，上傳文件的請求。
2. DispatcherServlet 收到請求調用 HandlerMapping 處理器映射器。
3. HandleMapping 根據請求 URI 找到對應的控制器以及攔截器，組裝成 HandlerExecutionChain 讀寫。將此對象返回給 DispatcherServlet，做下一步處理。
4. DispatcherServlet 調用 HanderAdapter 處理器適配器。這裡是適配器設計模式，進行接口轉換，將對一個接口調用轉換為其他方法。
5. HandlerAdapter 根據執行控制器方法，也就是開發人員寫的 Controller 類中的方法，並返回一個 ModeAndView
6. HandlerAdapter 返回 ModeAndView 給 DispatcherServlet
7. DispatcherServlet 調用 HandlerExceptionResolver 處理異常，有異常返回包含異常的 ModelAndView
8. DispatcherServlet 調用 ViewResolver 視圖解析器來 來解析 ModeAndView
9. ViewResolver 解析 ModeAndView 並返回真正的 View 給 DispatcherServlet
10. DispatcherServlet 將得到的視圖進行渲染，填充 Model 中數據到 request 域
11. 返回給客戶端響應結果

# SpringMVC 自動配置

在Spring MVC中，自動配置會創建多個物件，其中重要的包括：

- ContentNegotiatingViewResolver和BeanNameViewResolver物件：用於解析視圖(View)並返回給客戶端。
- 靜態資源支援：包括對WebJars的支援，使得靜態資源的處理更加方便。
- Converter、GenericConverter和Formatter物件的自動註冊：用於將請求參數轉換為目標物件，或將目標物件轉換為輸出流。
- HttpMessageConverters的支援：用於將請求或響應的內容轉換為Java對象或其他格式。
- MessageCodesResolver的自動註冊：用於處理錯誤消息。
- 靜態index.html支援：用於處理訪問根路徑時顯示的預設頁面。
- ConfigurableWebBindingInitializer的自動使用：用於設置WebDataBinder的初始化選項。

WebMvcAutoConfiguration 是 Spring MVC 自動配置類，源代碼如下：

```java
@AutoConfiguration(after = { DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
		ValidationAutoConfiguration.class })
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@ImportRuntimeHints(WebResourcesRuntimeHints.class)
public class WebMvcAutoConfiguration {
		// ...
}
```

- DispatcherServletAutoConfiguration.class：自動配置 DispatcherServlet
- WebMvcConfigurationSupport.class：配置 SpringMVC 的組件
- ValidationAutoConfiguration.class：配置 JSR-303 驗證器
- `@ConditionalOnWebApplication(type = Type.SERVLET)` ：應用是基於 SERVET 的 web 應用時有效
- `@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })`：當項目有 Servlet.class，DispatcherServlet.class  時起作用

以下是對 Spring MVC 相關的自動配置類做出的整理：

1. `DispatcherServletAutoConfiguration.class` 負責自動配置 `DispatcherServlet`，這是 Spring MVC 的核心組件之一，負責接收所有的 HTTP 請求並將它們分發到相應的處理程序。
2. `WebMvcConfigurationSupport.class` 負責配置 Spring MVC 的組件，包括處理程序映射、視圖解析器、異常處理程序等。
3. `ValidationAutoConfiguration.class` 負責配置 JSR-303 驗證器，可以對表單提交的數據進行驗證。
4. `@ConditionalOnWebApplication(type = Type.SERVLET)` 這個註解表示該配置類只有在基於 Servlet 的 Web 應用中才會生效。
5. `@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })` 這個註解表示該配置類只有在項目中存在 `Servlet.class`、`DispatcherServlet.class` 和 `WebMvcConfigurer.class` 這些類時才會生效。

## DispatcherServletAutoConfiguration

在傳統的 Spring MVC 中，需要在 `web.xml` 文件中配置 `DispatcherServlet`，但現在可以通過 `DispatcherServletAutoConfiguration` 類實現自動配置。

`DispatcherServletAutoConfiguration` 的作用：

1. 創建 `DispatcherServlet`，使用 `@Bean` 註解創建 `DispatcherServlet` 物件，並將其註冊為 Spring 容器中的 bean，名稱為 `dispatcherServlet`，並將其映射到 URL 模式為 "/" 的 Servlet 上。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eb2c0e19-9068-4045-bc3d-519f50fc6f7b/Untitled.png)

```java
@Bean(name = DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
public DispatcherServlet dispatcherServlet(WebMvcProperties webMvcProperties) {
	DispatcherServlet dispatcherServlet = new DispatcherServlet();
	dispatcherServlet.setDispatchOptionsRequest(webMvcProperties.isDispatchOptionsRequest());
	dispatcherServlet.setDispatchTraceRequest(webMvcProperties.isDispatchTraceRequest());
	dispatcherServlet.setThrowExceptionIfNoHandlerFound(webMvcProperties.isThrowExceptionIfNoHandlerFound());
	dispatcherServlet.setPublishEvents(webMvcProperties.isPublishRequestHandledEvents());
	dispatcherServlet.setEnableLoggingRequestDetails(webMvcProperties.isLogRequestDetails());
	return dispatcherServlet;
}
```

1. 創建 `MultipartResolver`，用於處理文件上傳。
2. 使用配置類 `WebMvcProperties.class` 來設置 `DispatcherServlet` 的一些屬性，例如前綴為 `spring.mvc`。

    ```java
    @ConfigurationProperties(prefix = "spring.mvc")
    public class WebMvcProperties { }
    ```


## WebMvcConfigurationSupport

在 Spring MVC 中，可以通過 Java Config 方式創建多個 HandlerMappings、HandlerAdapters 和 HandlerExceptionResolvers 的實例，以及其他組件，例如 `PathMatchConfigurer`、`ContentNegotiationManager`、`OptionalValidatorFactoryBean` 和 `HttpMessageConverters` 等。

以下是 Spring MVC 中常用的組件：

1. `HandlerMappings`：負責將請求映射到相應的處理程序。常用的 `HandlerMappings` 有 `RequestMappingHandlerMapping`。
2. `HandlerAdapter`：負責將請求交給相應的處理程序進行處理。常用的 `HandlerAdapter` 有 `RequestMappingHandlerAdapter`。
3. `HandlerExceptionResolver`：負責處理請求處理過程中發生的異常。常用的 `HandlerExceptionResolver` 有 `DefaultHandlerExceptionResolver` 和 `ExceptionHandlerExceptionResolver`（用於處理 `@ExceptionHandler` 註解）。

通過以上自動配置，Spring MVC 可以創建需要的 `DispatcherServlet` 、`HandlerMappings`、`HandlerAdapters`、`HandlerExceptionResolvers`，以及無視圖的 `HttpMessageConverters` 等物件。

## ServletWebServerFactoryAutoConfiguration

`ServletWebServerFactoryAutoConfiguration` 是 Spring Boot 中的一個自動配置類，用於配置嵌入式 Web 服務器

- `EmbeddedTomcat`
- `EmbeddedJetty`
- `EmbeddedUndertow`

Spring Boot 會檢測 classpath 上存在的類，從而判斷當前應用使用的是 Tomcat/Jetty/Undertow 中的哪一個 Servlet Web 服務器，從而決定定義相應的工廠組件，也就是 Web 服務器。

可以通過 ServerProperties.class 進行服務器配置，配置 web server 服務器

```java
@ConfigurationProperties(prefix = "server", ignoreUnknownFields = true)
public class ServerProperties {}
```

application 文件配置服務器，現在使用 tomcat 服務器

```yaml
spring:
  mvc:
    pathmatch:
      matching-strategy: path_pattern_parser
server:
  # 服務器端口號
  port: 8001
  servlet:
    # 上下文訪問路徑
    context-path: /api
    encoding:
      # request，response 字符編碼
      charset: UTF-8
      # 強制 request，response 設置 charset 字符編碼
      force: true
  tomcat:
    accesslog:
      # 啟用訪問日誌
      enabled: true
      # 日誌路徑
      directory: D:/exam
      # 日誌文件名前綴
      prefix: mylog
      # 日誌文件日期時間
      file-date-format: .yyyy-MM-dd
      # 日誌文件名稱後綴
      suffix: .log
    # 服務器最大連接數
    max-connections: 8000
    # post 請求內容最大值，默認 2M
    max-http-form-post-size: 2000000
```

Spring MVC 配置：

```yaml
spring:
  mvc:
    pathmatch:
      matching-strategy: path_pattern_parser
    servlet:
      # 配置訪問中央調度器的路徑，默認 /
      path: /course
      # Servlet 的加載順序，越小創建時間越早，默認-1
      load-on-startup: 0
      # 時間格式，可以在接受請求參數使用
    format:
      date-time: yyyy-MM-dd HH:mm:ss
```

```java
// 測試日期參數
@GetMapping("/param/date")
@ResponseBody
public String paramDate(LocalDateTime date) {
    return "時間： " + date;
}
```

- @DateTimeFormat 格式化日期，可以方法，參數，字段上使用。
  - 無須設置：spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss

```java
// @DateTimeFormat 格式化日期，可以方法，參數，字段上使用。
@GetMapping("/test/date")
@ResponseBody
public String paramDate2(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
    return "日期：" + date;
}
// 無須設置：spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss
```

## 重點整理

SpringMVC自動配置：

- DispatcherServletAutoConfiguration：配置中央調度器，設置他的名稱， load-on-start:-1, 默認的url-pattern: /
- WebMvcConfigurationSupport：配置SpringMVC的支持對象， HandlerMapping, HandlerAdapter, ViewResolver, HandlerExceptionResolver、HttpMessageConverters .. 靜態資源的對象
- ServletWebServerFactoryAutoConfiguration：配置Tomcat服務器， Jetty服務器

核心對象：
DispatcherServlet：Servlet， 使用doService()接收並處理請求。前端控制器

處理業務：
後端控制器， 開發人員自定義的Controller， 使用註解@Controller， @RestController

幫助處理請求的對象：
HandlerMapping：根據請求的uri地址，找到處理此請求的Controller對象（Spring容器中的）
HandlerAdapter：使用適配器模式，調用執行具體的控制器方法。
ViewResolver：處理視圖，創建視圖對象View。
HandlerExceptionResolver：異常處理器，處理請求中的異常。

**註解**：

1. 控制器@Controller, @RestController
2. 接收請求 @RequestMapping, @GetMapping, @PostMapping, @PutMapping ,@DeleteMapping
3. 接收參數 @RequestParam ,@RequestHeader, @RequestBody
4. 校驗參數 @Validated , JSR 303註解
5. 返回值表示數據的@ResponseBody
6. 支持RESTful的路徑變量 @PathVariable

# Servlets, Filters, and Listeners

Web 應用中還會使用到 Servlet、Filter 或 Listener 等組件，這些組件可以作為 Spring Bean 註冊到嵌入式的 Tomcat 中。

可以使用 `ServletRegistrationBean`、`FilterRegistrationBean` 和 `ServletListenerRegistrationBean` 來控制 Servlet、Filter 和 Listener 的註冊。

可以使用 `@Order` 或實現 `Ordered` 接口來控制這些組件註冊的先後順序。

現在的 Servlet 已經完全支持註解的使用方式，可以使用 `@WebServlet` 註解來定義一個 Servlet。

新 SpringBoot 項目 Lession13-ServletFilter, 構建工具 Maven， 包名 [com.bjpowernode.web](http://com.bjpowernode.web/)，依賴 Spring Web、Lombok ，JDK19.

## Servlets

### @WebServlet 使用 Servlet

範例：

- 新建一個 Servlet

    ```java
    /**
     * @WebServlet：等同於 web.xml 中，有關 Servlet 的聲明
     * <servlet>
     *     <servlet-name>HelloServlet</servlet-name>
     *     <servlet-class>xxxx</servlet-class>
     * </servlet>
     * <servlet-mapping>
     *     <servlet-name>HelloServlet</servlet-name>
     *     <url-pattern>/helloServlet</url-pattern>
     * </servlet-mapping>
     */
    @WebServlet(urlPatterns = "/helloServlet", name = "HelloServlet")
    public class HelloServlet extends HttpServlet {
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("這是一個Spring Boot 中的 Servlet");
            writer.flush();
            writer.close();
        }
    
    }
    ```

- 啟動類增加掃描注解

    ```java
    @ServletComponentScan(basePackages = "com.example.servletfilter.servlet")
    @SpringBootApplication
    public class App {
    
    	public static void main(String[] args) {
    		SpringApplication.run(App.class, args);
    	}
    
    }
    ```


### ServletRegistrationBean

`ServletRegistrationBean` 用於編程式地向嵌入式的 Servlet 容器中註冊 Servlet。

相比於使用註解的方式，使用 `ServletRegistrationBean` 可以更加靈活地控制 Servlet 的註冊。例如，可以通過 `ServletRegistrationBean` 設置 Servlet 的 URL 映射、初始化參數、啟用/禁用等等。

範例：

- 創建一個 Servlet

    ```java
    public class LoginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.println("這是一個登入的 Servlet");
            writer.flush();
            writer.close();
        }
    }
    ```

- 創建Config

    ```java
    @Configuration
    public class WebAppConfig {
        @Bean
        public ServletRegistrationBean<LoginServlet> addServlet() {
            ServletRegistrationBean<LoginServlet> registrationBean = new ServletRegistrationBean<>();
            registrationBean.setServlet(new LoginServlet());
            registrationBean.addUrlMappings("/user/login");
            registrationBean.setLoadOnStartup(1);
            return registrationBean;
        }
    }
    ```


## 創建 Filter

Filter 物件可以用於記錄日誌、權限驗證、敏感字元過濾等功能。在 Web 框架中，一般都內置了 Filter 物件，比如 SpringMVC 中就包含了許多內置的 Filter，例如 CommonsRequestLoggingFilter、CorsFilter 和 FormContentFilter 等。若有需要，開發者也可以自行編寫 Filter 物件來實現特定的功能。

### @WebFilter 註解

`@WebFilter` 是一個 Java Annotation，用於創建 Filter 物件。使用方式類似 `@WebServlet`，只需在 Filter 的類別前加上 @WebFilter 注解即可。在 @WebFilter 中，可以指定 Filter 的 URL 模式、Filter 名稱、Filter 順序等屬性。

範例：

- 創建 Filter

    ```java
    @WebFilter(urlPatterns = "/*")
    public class LogFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            String uri = ((HttpServletRequest)request).getRequestURI().toString();
            System.out.println("過濾器執行了， uri: " + uri);
            chain.doFilter(request, response);
        }
    }
    ```

- 啟動類上添加註解

    ```java
    @ServletComponentScan(basePackages = "com.example.servletfilter")
    @SpringBootApplication
    public class Lesson13ServletFilterApplication {
    
    	public static void main(String[] args) {
    		SpringApplication.run(Lesson13ServletFilterApplication.class, args);
    	}
    
    }
    ```


### FilterRegistrationBean

FilterRegistrationBean 與 ServletRegistrationBean 使用方式類似，無需註解。

範例：

- 在 Config 註冊 Filter

    ```java
    @Configuration
    public class WebAppConfig {
        @Bean
        public FilterRegistrationBean addFilter() {
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
            filterRegistrationBean.setFilter(new LogFilter());
            filterRegistrationBean.addUrlPatterns("/*");
            return filterRegistrationBean;
        }
    }
    ```


### Filter 排序

如果有多個 Filter 物件需要執行，可能需要對它們進行排序。通常有兩種方式可以實現 Filter 物件的排序：

1. 按照 Filter 類別名稱的字典順序進行排序，例如 AuthFilter 排在 LogFilter 之前。
2. 使用 FilterRegistrationBean，設置 Filter 的順序。數值越小的 Filter 會先執行。

範例：

- 創建兩個 Filter，AuthFilter、LogFilter

    ```java
    public class AuthFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            String uri = ((HttpServletRequest)request).getRequestURI().toString();
            System.out.println("AuthFilter執行了， uri: " + uri);
            chain.doFilter(request, response);
        }
    }
    ```

    ```java
    public class LogFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            String uri = ((HttpServletRequest)request).getRequestURI().toString();
            System.out.println("LogFilter執行了， uri: " + uri);
            chain.doFilter(request, response);
        }
    }
    ```

- 在 Config 註冊 Filter

    ```java
    // 註冊 Filter，指定順序
    @Bean
    public FilterRegistrationBean addLogFilter() {
        FilterRegistrationBean log = new FilterRegistrationBean();
        log.setFilter(new LogFilter());
        log.addUrlPatterns("/*");
        log.setOrder(2); // 設置順序
        return log;
    }
    
    @Bean
    public FilterRegistrationBean addAuthFilter() {
        FilterRegistrationBean auth = new FilterRegistrationBean();
        auth.setFilter(new AuthFilter());
        auth.addUrlPatterns("/*");
        auth.setOrder(3); // 越小越先執行
        return auth;
    }
    ```


### 使用框架中的 Filter

在 Spring Boot 中，有許多已經定義好的 Filter 物件，這些 Filter 物件實現了一些常用的功能。如果我們需要使用這些 Filter 物件，可以像使用自己的 Filter 一樣，通過 `FilterRegistrationBean` 註冊這些 Filter 物件。

例如，如果我們想要記錄每個請求的日誌，可以使用 CommonsRequestLoggingFilter 這個 Filter 物件來完成簡單的請求記錄。

範例：

- 註冊 CommonsRequestLoggingFilter

    ```java
    @Bean
    public FilterRegistrationBean addOtherFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 創建 Filter 對象
        CommonsRequestLoggingFilter commonLog = new CommonsRequestLoggingFilter();
        // 包含請求uri
        commonLog.setIncludeQueryString(true);
        // 登記 Filter
        filterRegistrationBean.setFilter(commonLog);
        // 攔截所有地址
        filterRegistrationBean.addUrlPatterns("/*");
    
        return filterRegistrationBean;
    }
    ```

- 設置日誌級別為 debug

    ```yaml
    logging:
      level:
        web: debug
    ```


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/220e1a73-6012-4e57-8da1-a8c2c02b1049/Untitled.png)

## Listener

@WebListener 是一個用於註釋監聽器的註解。如果我們想要實現一個監聽器，就可以在監聽器類別上加上 @WebListener 註解。

在實現監聽器時，我們需要實現以下介面之一：

- jakarta.servlet.http.HttpSessionAttributeListener：用於監聽 HttpSession 物件中屬性的變化。
- jakarta.servlet.http.HttpSessionListener：用於監聽 HttpSession 物件的創建和銷毀事件。
- jakarta.servlet.ServletContextAttributeListener：用於監聽 ServletContext 物件中屬性的變化。
- jakarta.servlet.ServletContextListener：用於監聽 ServletContext 物件的創建和銷毀事件。
- jakarta.servlet.ServletRequestAttributeListener：用於監聽 ServletRequest 物件中屬性的變化。
- jakarta.servlet.ServletRequestListener：用於監聽 ServletRequest 物件的創建和銷毀事件。
- jakarta.servlet.http.HttpSessionIdListener：用於監聽 HttpSession 的 ID 變化事件。

除了使用 @WebListener 註解註冊監聽器外，還可以使用 ServletListenerRegistrationBean 類別來註冊監聽器。

- 創建 Listner

    ```java
    @WebListener("Listener 的描述說明")
    public class MySessionListener implements HttpSessionListener {
    	@Override
    	public void sessionCreated(HttpSessionEvent se) {
    		HttpSessionListener.super.sessionCreated(se);
    	}
    }
    ```


# WebMvcConfigurer

WebMvcConfigurer 是一個用於配置 Spring MVC 框架的介面，它提供了一些方法，用於自定義 Spring MVC 的行為。使用 WebMvcConfigurer 可以代替傳統的 XML 配置文件，使用 JavaBean 的形式來進行配置。

WebMvcConfigurer 可以用於自定義 Interceptor、ViewResolver、MessageConverter 等 Spring MVC 的組件。我們可以創建一個類，實現 WebMvcConfigurer 介面，然後覆蓋需要自定義的方法，來實現對 Spring MVC 框架的個性化定制。

主要功能如下：

```java
public interface WebMvcConfigurer {
		// 配置 HandlerMapping(路徑匹配器)
    default void configurePathMatch(PathMatchConfigurer configurer) {
    }
		// 配置內容協商選項
    default void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }
		// 配置異步支持
    default void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }
		// 配置默認的Servlet處理程序。
    default void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }
		// 添加格式化程序
    default void addFormatters(FormatterRegistry registry) {
    }
		// 添加攔截器
    default void addInterceptors(InterceptorRegistry registry) {
    }
		// 加靜態資源處理程序
    default void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
		// 加跨源資源共享(CORS)映射
    default void addCorsMappings(CorsRegistry registry) {
    }
		// 添加視圖控制器
    default void addViewControllers(ViewControllerRegistry registry) {
    }
		// 配置視圖解析器
    default void configureViewResolvers(ViewResolverRegistry registry) {
    }
		// 添加處理程序方法引數解析器
    default void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    }
		// 添加處理程序方法返回值處理器
    default void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    }
		// 配置消息轉換器
    default void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }
		// 擴展消息轉換器
    default void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }
		// 配置處理程序異常解析器
    default void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }
		// 擴展處理程序異常解析器
    default void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }
		// 獲取JSR303驗證器
    @Nullable
    default Validator getValidator() {
        return null;
    }
		// 獲取消息代碼解析器
    @Nullable
    default MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
```

## 頁面跳轉控制器

在 Spring Boot 中，如果需要使用頁面視圖（例如 Thymeleaf），則需要通過 Controller 對象來實現跳轉顯示某個頁面的功能。換句話說，我們需要創建一個 Controller，將請求轉發到一個視圖才能顯示頁面。

但是，在某些情況下，我們可能只需要顯示一個靜態的頁面，或者將某個 URL 路徑映射到另一個 URL 路徑上。這時候，我們可以使用 Spring Boot 提供的 addViewControllers() 方法，來簡化 Controller 的創建。

addViewControllers() 方法可以讓我們在應用程序啟動時，將某個 URL 路徑映射到指定的視圖上。這樣，在訪問這個 URL 路徑時，就可以直接顯示指定的視圖，而無需再通過 Controller 對象轉發請求。

範例：

- 創建 View

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>WebMvcConfigurer</title>
        </head>
        <body>
            <h3>WebMvcConfigurer測試頁面</h3>
        </body>
    </html>
    ```

- 創建 Spring MVC 配置類

    ```java
    @Configuration
    public class MvcSettings implements WebMvcConfigurer {
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/welcome").setViewName("index");
        }
    }
    ```


在上述範例中，我們創建了一個 MvcSettings 類，並實現了 WebMvcConfigurer 介面。然後我們覆蓋了 addViewControllers 方法，使用 ViewControllerRegistry 將 `/welcome` URL 路徑映射到 index.html 視圖上。

通過這種方式，我們可以簡化 Controller 的創建，使代碼更加簡潔。同時，這種方式還可以提高應用程序的性能，因為無需再通過 Controller 對象轉發請求。

## 數據格式化

Formatter<T>是數據轉換介面，用於將一種數據類型轉換為另一種數據類型。與 Formatter<T> 功能類型相似的還有 Converter<S, T>。本節將研究 Formatter<T> 介面。Formatter<T> 只能將 String 類型轉換為其他數據類型。這在 Web 應用中尤其常用，因為 Web 請求的所有參數都是 String，我們需要將 String 轉換為 Integer、Long、Date 等其他數據類型。

Spring 中內置了多個 Formatter<T>：

- DateFormatter ： String 和 Date 之間的解析與格式化
- InetAddressFormatter ：String 和 InetAddress 之間的解析與格式化
- PercentStyleFormatter ：String 和 Number 之間的解析與格式化，帶貨幣符合
- NumberFormat ：String 和 Number 之間的解析與格式化

當我們使用 @DateTimeFormat 和 @NumberFormat 注解時，就是通過 Formatter<T> 將 String 類型解析為我們期望的 Date 或 Number 類型。

Formatter<T> 也是 Spring 的擴展點，我們可以自定義 Formatter<T> 來處理特殊格式的請求數據，將請求的 String 數據轉換為我們需要的某個對象，這樣使用這個對象更方便我們的後續編碼。

Formatter<T> 是一個組合介面，沒有自己的方法，內容來自 Printer<T> 和 Parser<T>，代碼如下：

```java
public interface Formatter<T> extends Printer<T>, Parser<T> {}
```

- Printer<T> 用於將 T 類型轉換為 String，進行格式化輸出；Parser<T> 用於將 String 類型轉換為期望的 T 對象。

在項目開發中，我們可能會面對多種類型的項目，有些複雜度較簡單，有些則複雜一些。特別是與硬件打交道的項目，數據格式可能與一般的 "**name: lisi, age: 20**" 不同，例如數據可能是 "**1111; 2222; 333,NF; 4; 561**"。

需求：將"**1111; 2222; 333,NF; 4; 561**"接受，代碼中用 DeviceInfo 存儲參數

範例：

- 創建 DeviceInfo

    ```java
    @Data
    public class DeviceInfo {
        private String item1;
        private String item2;
        private String item3;
        private String item4;
        private String item5;
    }
    ```

- 自定義 Formatter

    ```java
    public class DeviceFormatter implements Formatter<DeviceInfo> {
        @Override
        public DeviceInfo parse(String text, Locale locale) throws ParseException {
            DeviceInfo info = null;
            if (StringUtils.hasLength(text)) {
                String[] items = text.split(";");
                info = new DeviceInfo();
                info.setItem1(items[0]);
                info.setItem2(items[1]);
                info.setItem3(items[2]);
                info.setItem4(items[3]);
                info.setItem5(items[4]);
            }
            return info;
        }
    
        // 將 DeviceInfo 轉為 String
        @Override
        public String print(DeviceInfo object, Locale locale) {
            StringJoiner joiner = new StringJoiner("#");
            joiner.add(object.getItem1()).add(object.getItem2());
    
            return joiner.toString();
        }
    }
    ```

- 註冊自定義 Formatter

    ```java
    @Configuration
    public class MvcSettings implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new DeviceFormatter());
        }
    }
    ```

- 建立Controller

    ```java
    @RestController
    public class DeviceController {
    
        @PostMapping("/device/add")
        public String addDevice(@RequestParam("info") DeviceInfo info) {
    //        DeviceFormatter formatter = new DeviceFormatter();
    //        String formattedString = formatter.print(info, Locale.getDefault());
    //        return "接收到的設備數據: " + formattedString;
            return "接收到的設備數據： " + info.toString();
        }
        
    }
    ```


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8a6d0fb9-0477-48bb-aec6-ab01f345716f/Untitled.png)

## 攔截器

HandlerInterceptor 介面和它的實現類稱為攔截器，是 SpringMVC 的一種物件，和 Servlet 無關。攔截器能夠預先處理發給 Controller 的請求，可以決定請求是否被 Controller 處理。用戶請求是先由 DispatcherServlet 接收後，在 Controller 之前執行的攔截器對象。
一個項目中有眾多的攔截器：框架中預定義的攔截器， 自定義攔截器。
根據攔截器的特點，類似權限驗證，記錄日誌，過濾字符，登錄 token 處理都可以使用攔截器。
攔截器定義步驟：

1. 聲明類實現 HandlerInterceptor 接口，重寫三個方法（依照需求覆寫所需方法）
2. 登記攔截器

### 一個攔截器

範例：

- 創建 Controller

    ```java
    @RestController
    public class ArticleController {
    
        @PostMapping("/article/add")
        public String addArticle(){
            return "發布新的文章";
        }
        @PostMapping("/article/edit")
        public String editArticle(){
            return "修改文章";
        }
        @GetMapping("/article/query")
        public String query(){
            return "查詢文章";
        }
        
    }
    ```

- 創建攔截器

    ```java
    public class AuthInterceptor implements HandlerInterceptor {
    
        private final String COMMON_USER = "lisa";
    
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("=====AuthInterceptor 權限攔截器=====");
            // 獲取登陸的用戶
            String loginUser = request.getParameter("loginUser");
            System.out.println("loginUser = " + loginUser);
            // 獲取操作的 url
            String requestURI = request.getRequestURI();
            System.out.println("requestURI = " + requestURI);
    
            return COMMON_USER.equals(loginUser) &&
                   (requestURI.startsWith("/article/add")
                    || requestURI.startsWith("/article/edit")
                    || requestURI.startsWith("/article/remove"));
        }
    }
    ```

- 註冊攔截器

    ```java
    @Configuration
    public class MvcSettings implements WebMvcConfigurer {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            AuthInterceptor authInterceptor = new AuthInterceptor();
            registry.addInterceptor(authInterceptor)
                    .addPathPatterns("/article/**")         // 攔截article開始的所有要求
                    .excludePathPatterns("/article/query"); // 排除/article/query請求
        }
    
    }
    ```


### 多個攔截器

增加一個驗證登錄用戶的攔截器，只有 lisa、susan、admin 能夠登錄系統。其他用戶不可以。
兩個攔截器登錄的攔截器先執行，權限攔截器後執行，order()方法設置順序，整數值越小，先執行

範例：

- 創建攔截器

```java
public class LoginInterceptor implements HandlerInterceptor {

    private final List<String> permitUser;

    public LoginInterceptor() {
        permitUser = List.of("lisa", "susan", "admin", "root");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====LoginInterceptor 登入攔截器=====");
        // 獲取登陸的用戶
        String loginUser = request.getParameter("loginUser");

        return StringUtils.hasText(loginUser) && permitUser.contains(loginUser);
    }
} 
```

- 註冊攔截器，設置order

    ```java
    @Configuration
    public class MvcSettings implements WebMvcConfigurer {
    		// 攔截器
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            // 權限攔截器
            AuthInterceptor authInterceptor = new AuthInterceptor();
            registry.addInterceptor(authInterceptor)
                    .order(2)
                    .addPathPatterns("/article/**")         // 攔截article開始的所有要求
                    .excludePathPatterns("/article/query"); // 排除/article/query請求
    
            // 登入攔截器
            LoginInterceptor loginInterceptor = new LoginInterceptor();
            registry.addInterceptor(loginInterceptor)
                    .order(1)                               // 順序，整數值，越小越先執行
                    .addPathPatterns("/**")                 // 攔截所有請求
                    .excludePathPatterns("/article/query"); // 排除/article/query請求
        }
    }
    ```


# 文件上傳

在 Spring Boot 中，文件上傳可以使用 MultipartResolver 介面來解析上傳的請求，代替了以前使用的 Apache Commons FileUpload 庫。

Spring Boot 中提供了 StandardServletMultipartResolver 類來實現 MultipartResolver 介面，用於讀取 POST 請求中的請求數據，即文件內容。

在 Controller 的方法中，可以使用@RequestParam MultipartFile 形參來獲取上傳的文件，並提供了方便的方法將文件保存到磁盤。

需要注意的是，在 Spring Boot3 版本中，不能再使用 CommonsMultipartResolver，而是需要使用 StandardServletMultipartResolver。這個新的實現使得文件上傳變得更加簡單和方便。

- MultipartFile API


    | 方法  | 作用 |
    | --- | --- |
    | getName() |  參數名稱（upfile） |
    | getOriginalFilename()  | 上傳文件原始名稱 |
    | isEmpty() | 上傳文件是否為空 |
    | getSize() | 上傳的文件字節大小 |
    | getInputStream() | 文件的 InputStream，可用於讀取部件的內容 |
    | transferTo(File dest) |  保存上傳文件到目標 dest |

## MultipartResolver

範例：

- 創建 index.html

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>首頁</title>
        </head>
        <body>
            <h3>項目首頁，上傳文件成功</h3>
        </body>
    </html>
    ```

- 創建 upload.html

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            <div style="margin-left: 200px">
                <h3>上傳文件</h3>
                <form action="uploadFile" enctype="multipart/form-data" method="post">
                    選擇文件： <input type="file" name="upfile"> <br/>
                    <input type="submit" value="上傳文件">
                </form>
            </div>
        </body>
    </html>
    ```

  - 要求：
    - `enctype="multipart/form-data"`
    - `method="post"`
    - `<input type="file" name="upfile">` 表示一個上傳文件，upfile 自定義上傳文件參數名稱
- 創建 Controller

    ```java
    @Controller
    public class UploadFileController {
    
        @PostMapping("/uploadFile")
        public String uploadFile(@RequestParam("upfile") MultipartFile multipartFile) {
            Map<String, Object> info = new HashMap<>();
    
            try {
                if (!multipartFile.isEmpty()) {
                    info.put("上傳文件參數名", multipartFile.getName());   // upfile
                    info.put("內容類型", multipartFile.getContentType());
    
                    var ext = "unknown";
                    var filename = multipartFile.getOriginalFilename();    // 原始文件名稱，例如 a.png
                    if (filename.indexOf(".") > 0) {
                        ext = filename.substring(filename.indexOf(".") + 1);
                    }
    
                    var newFileName = UUID.randomUUID() + "." +  ext;
                    var path = "D:/upload/" + newFileName;
                    info.put("上傳後文件名稱", newFileName);
    
                    multipartFile.transferTo(new File(path));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("info = " + info);
            //防止刷新、重複上傳，重定向到index页面
            return "redirect:/index.html";
        }
    }
    ```


這邊需要注意的是

Spring Boot 默認單個文件最大支持 1M，一次請求最大 10M。改變默認值，需要 application 修改配置

```yaml
spring:
    servlet:
        multipart:
            max-file-size: 100KB
            max-request-size: 5MB
						# file-size-threshold 超過指定大小，直接寫文件到磁盤，不在內存處理
            file-size-threshold: 0KB
```

配置錯誤頁面

- resources/static/error/5xx.html

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b9daa1db-ee9d-418f-b122-49215922d70a/Untitled.png)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7c6a583f-591c-43a4-ba76-d2f43741c809/Untitled.png)

## Servlet 規範

Servlet 規範定義了處理 multipart/form-data POST 請求中接收到表單數據的 jakarta.servlet.http.Part 介面。透過 Part 介面的 write() 方法，可以將上傳的文件保存到服務器本地磁盤目錄。

在 HttpServletRequest 介面中，新增了以下方法：

- getParts()：返回 Part 物件的集合。
- getPart(字串名稱)：檢索具有給定名稱的單個 Part 物件。

Spring Boot 3 使用基於 Servlet 5 的 Servlet 規範，因此使用 Part 介面進行文件上傳。StandardServletMultipartResolver 將 Part 介面進行封裝，實現基於 Servlet 規範的文件上傳。原生的 Servlet 規範也支援文件上傳。

範例：

使用原始 Part介面 進行文件上傳處理

- 創建 Controller

    ```java
    @Controller
    public class UploadAction {
    
        @PostMapping("files")
        public String upload(HttpServletRequest request) {
            try {
                for (Part part: request.getParts()) {
                    String filename = extractFileName(part);
                    // 將文件寫入到服務器的目錄
                    part.write(filename);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return "redirect:/index.html";
        }
    
        private String extractFileName(Part part) {
            // 上傳文件包含 header 頭 content-disposition，類似下面的內容, 可獲取文件原始名稱。
            // 如：form-data; name="dataFile"; filename="header.png"
            String contentDisp = part.getHeader("content-disposition");
            System.out.println("contentDisp = " + contentDisp);
            String[] items = contentDisp.split(";");
            for (String s: items) {
                if (s.trim().startsWith("filename")) {
                    return s.substring(s.indexOf("=") + 2, s.length() - 1);
                }
            }
            return "";
        }
    }
    ```

- 配置 application.yml

    ```yaml
    spring:
        servlet:
            multipart:
                location: D:/upload/
    ```

- 配置頁面

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            <div style="margin-left: 200px">
                <h3>上傳文件</h3>
                <form action="files" enctype="multipart/form-data" method="post">
                    選擇文件-action： <input type="file" name="upfile"> <br/>
                    <input type="submit" value="上傳文件">
                </form>
            </div>
        </body>
    </html>
    ```


## 多文件上傳

在接收文件參數部分有所改變 MultiPartFile [] files 。循環遍歷數組解析每個上傳的文件。

- 新增 html

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            <div style="margin-left: 200px">
                <h3>上傳文件</h3>
                <form action="uploadMultiFile" enctype="multipart/form-data" method="post">
                    選擇文件 1： <input type="file" name="upfile"> <br/>
                    選擇文件 2： <input type="file" name="upfile"> <br/>
                    選擇文件 3： <input type="file" name="upfile"> <br/>
                    <input type="submit" value="上傳文件">
                </form>
            </div>
        </body>
    </html>
    ```

- 新增 Controller

    ```java
    @Controller
    public class UploadFileMultiController {
    
        @PostMapping("/uploadMultiFile")
        public String uploadFile(@RequestParam("upfile") MultipartFile[] multipartFiles) {
            Map<String, Object> info = new HashMap<>();
    
            try {
                for (MultipartFile multipartFile : multipartFiles) {
                    if (!multipartFile.isEmpty()) {
                        info.put("上傳文件參數名", multipartFile.getName());   // upfile
                        info.put("內容類型", multipartFile.getContentType());
    
                        var ext = "unknown";
                        var filename = multipartFile.getOriginalFilename();    // 原始文件名稱，例如 a.png
                        if (filename.indexOf(".") > 0) {
                            ext = filename.substring(filename.indexOf(".") + 1);
                        }
    
                        var newFileName = UUID.randomUUID() + "." + ext;
                        var path = "D:/upload/" + newFileName;
                        info.put("上傳後文件名稱", newFileName);
    
                        multipartFile.transferTo(new File(path));
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("info = " + info);
            //防止刷新、重複上傳，重定向到index页面
            return "redirect:/index.html";
        }
    }
    ```


# 全局異常處理

在 Controller 處理請求時，若發生異常，DispatcherServlet 會將異常處理委託給異常處理器（處理異常的類）。
實現 HandlerExceptionResolver 介面的都是異常處理類。為了方便統一處理異常，一般會定義全局異常處理器。
可以結合框架提供的註解，例如：@ExceptionHandler、@ControllerAdvice、@RestControllerAdvice 來完成異常處理。
其中，@RestControllerAdvice 與 @ControllerAdvice 的差異在於前者加了 @ResponseBody。

## 全局異常處理器

範例：

需求：應用計算兩個數字相除，當用戶被除數為 0 ，發生異常。使用自定義異常處理器代替默認的異常處理程序。

- 創建 input.html 頁面

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
          <form action="divide" method="post">
            除&nbsp;&nbsp;&nbsp;數：<input type="text" name="n1"> <br/>
            被除數：<input type="text" name="n2"> <br/>
            <input type="submit" value="計算">
          </form>
        </body>
    </html>
    ```

- 創建 Controller

    ```java
    @RestController
    public class NumberController {
    
        @PostMapping("/divide")
        public String some(Integer n1, Integer n2) {
            int result = n1 / n2;
            return "n1 / n2 = " + result;
        }
    }
    ```

- 創建自定義異常處理器
  - 返回view 視圖

      ```java
      /**
       * 1. 在 class 的上面加入@ControllerAdvice，@RestControllerAdvice
       * 靈活組合@ControllerAdvice 和 @ResponseBody
       * 2. 在 class 中自定義方法，處裡各種異常
       * 方法定義同 Controller類中的方法定義
       */
      // 控制器增強，給Controller增加異常處理功能，類似AOP的思想
      @ControllerAdvice
      public class GlobalExceptionHandler {
      
          // 定義方法處理，數學異常
          /**
           * @ExceptionHandler：指定處理異常的方法
           * 位置：在方法的上面
           * 屬性：是異常類的class數組，如果系統拋出的異常類型與@ExceptionHandler聲明的相同，則由當前方法處理異常
           */
          @ExceptionHandler({ArithmeticException.class})
          public String handlerArithmeticException(ArithmeticException exception, Model model) {
              String error = exception.getMessage();
              model.addAttribute("error", error);
              return "exp";
          }
      }
      ```

  - 返回json數據

      ```java
      /**
       * 1. 在 class 的上面加入@ControllerAdvice，@RestControllerAdvice
       * 靈活組合@ControllerAdvice 和 @ResponseBody
       * 2. 在 class 中自定義方法，處裡各種異常
       * 方法定義同 Controller類中的方法定義
       */
      // 控制器增強，給Controller增加異常處理功能，類似AOP的思想
      @ControllerAdvice
      public class GlobalExceptionHandler {
          // 定義方法處理，數學異常
          @ExceptionHandler({ArithmeticException.class})
          @ResponseBody
          public Map<String, String> handlerReturnDataException(ArithmeticException exception) {
              Map<String, String> error = new HashMap<>();
              error.put("msg", exception.getMessage());
              error.put("tips", "被除數不能為0");
      
              return error;
          }
      }
      ```

- 創建錯誤提示頁面exp.html

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
          <h3>顯示異常信息：<div th:text="${error}"></div></h3>
        </body>
    </html>
    ```


![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4313778c-f85f-46a4-8dc1-5ed8ad917a6e/Untitled.png)

> 建議在參數簽名中盡可能具體異常類，以減少異常類型和原因異常之間不匹配的問題，考慮創建多個@ExceptionHandler 方法的。
每個方法通過其簽名匹配單個特定的異常類型。最後增加一個根異常，考慮沒有匹配的其他情況
>

## BeanValidator 異常處理

在 Controller 方法中使用 JSR-303 驗證參數時，我們需要聲明 BindingResult 物件來獲取校驗結果。由於 Controller 方法很多，每個方法都需加入 BindingResult 處理檢驗參數比較繁瑣。因此，可以將校驗參數失敗時的異常拋出給框架，異常處理器能夠捕獲到 MethodArgumentNotValidException，它是 BindException 的子類。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fab5c049-8b90-4126-811a-a77537df2cb9/Untitled.png)

BindException 異常實現了 BindingResult 介面，異常類能夠得到 BindingResult 對象，進一步獲取 JSR303 校驗的異常信息。

範例：

需求：全局處理 JSR303 校驗異常

- 添加 JSR-303 依賴

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```

- 創建 Bean ，屬性加入 JSR-303 註解

    ```java
    @Data
    public class OrderVO {
        @NotBlank(message = "訂單名稱不能為空")
        private String name;
    
        @NotNull(message = "商品必須有數量")
        @Range(min= 1, max =  99 ,message = "一個訂單的商品數量在{min}-{max}")
        private Integer amount;
    
        @NotNull(message = "用戶不能為空")
        @Min(value = 1,message = "從1開始")
        private Integer userId;
    }
    ```

- 創建 Controller

    ```java
    @RestController
    public class OrderController {
        @PostMapping("/order/new")
        public String createOrder(@Validated @RequestBody OrderVO orderVO){
            return "訂單信息：" + orderVO.toString();
        }
    }
    ```

- 創建 異常處理器

    ```java
    @ControllerAdvice
    public class GlobalExceptionHandler {
        // 處理 JSR303 驗證參數的異常
        @ExceptionHandler({MethodArgumentNotValidException.class})
        @ResponseBody
        public Map<String, Object> handlerJSR303Exception (MethodArgumentNotValidException e) {
            System.out.println("========JSR 303========");
            Map<String, Object> map = new HashMap<>();
            BindingResult result = e.getBindingResult();
            if (result.hasErrors()) {
                List<FieldError> errors = result.getFieldErrors();
                for (int i = 0; i < errors.size(); i++) {
                    FieldError fieldError = errors.get(i);
                    map.put(i + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            return map;
        }
       
    }
    ```


## ProblemDetail [SpringBoot 3]

在 Spring Boot 3 中，對錯誤信息進行了增強。

在過去的 Spring Boot 版本中，默認的異常反饋內容比較單一，只包含 Http Status Code、時間和異常信息，無法體現具體的異常原因。

![Spring Boot默認錯誤信息](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bec02cc6-2017-4255-a059-b686aadf8e70/Untitled.png)

Spring Boot默認錯誤信息

`ProblemDetail` 是一個遵循 RFC 7807 的規範，用於描述應用程式中出現的問題的類型。在 Spring Boot 3 中，`ProblemDetail` 是一個新的 API，它提供了一種標準的方式來描述和傳遞錯誤信息，包括錯誤類型、狀態碼、標題、詳細信息和其他相關的元數據。

使用 `ProblemDetail` 可以幫助開發人員更加方便地處理錯誤信息，尤其是在 RESTful API 開發中。通過使用 `ProblemDetail`，開發人員可以更好地描述和傳遞錯誤信息，同時客戶端也可以更好地理解和處理這些錯誤信息，從而提高了應用程式的可靠性和易用性。

### RFC 7807

RFC 7807（Problem Details for HTTP APIs）：[官網](https://www.rfc-editor.org/rfc/rfc7807)

RFC 7807 是一個定義了錯誤回報格式的文件，也稱為「問題詳述」或「問題類型」。它定義了一種標準的 JSON 格式，用於描述 API 的錯誤。該文件於 2016 年發布，旨在提供一種一致的方式，讓 API 用戶能夠更容易理解錯誤發生的原因，進而更快地診斷和解決問題。

在 RESTful 服務中，通常需要在響應體中包含錯誤詳情。為此，RFC 7807 提出了**Problem Details**的概念，定義了 Http 應答錯誤的處理細節，增強了響應錯誤的內容。該規範包含標準和非標準的字段，同時支持 json 和 xml 兩種格式。在基於 Http 協議的請求中，我們可以通過 Http Status Code 分析響應結果，但 status code 過於簡單，不能進一步說明具體的錯誤原因和解決途徑。比如 http status code 403，但並不能說明 **是什麼導致了 403** 以及如何解決問題。因此，RFC 7807 對這些做了規範的定義。

- **Problem Details** 的 JSON 應答格式

```json
{
	"type": "https://example.com/probs/out-of-credit",
	"title": "You do not have enough credit.",
	"detail": "Your current balance is 30, but that costs 50.",
	"instance": "/account/12345/transactions/abc"
} 
```

- **Problem Details** 包含內容

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/77e52d25-51df-4e6b-b1f6-5c9ca16cb24e/Untitled.png)


| 標準字段 | 描述 | 必須 |
| --- | --- | --- |
| type | 標識錯誤類型的 URI。在瀏覽器中加載這個 URI 應該轉向這個錯誤的文檔。此字段可用於識別錯誤類。完善的系統可用 type 構建異常處理模塊，默認為 about:blank | 可認為是 |
| title | 問題類型的簡短、易讀的摘要 | x |
| detail | 錯誤信息詳細描述，對 title 的進一步闡述 | x |
| instance | 標識該特定故障實例的 URI。它可以作為發生的這個錯誤的 ID | x |
| status | 錯誤使用的 HTTP 狀態代碼。它必須與實際狀態匹配 | x |

除了以上字段，用戶可以擴展字段。採用 key：value 格式。增強對問題的描述。

### MediaType

RFC 7807 規範引入了兩種新的媒體類型：`application/problem+json`和`application/problem+xml`。當 HTTP 響應返回錯誤時，應在其`Content-Type`響應標頭中包含適當的內容類型，客戶端可以通過檢查該標頭來確認返回的格式。

[異常響應結果](https://www.notion.so/3918279d4186422f9c5b7b0e33e424e2)

### Spring 支持 Problem Detail

- ProblemDetail 類：封裝標準字段和擴展字段的簡單對象
- ErrorResponse：錯誤應答類，完整的 RFC 7807 錯誤響應的表示，包括 status、headers 和 RFC 7807 格式的ProblemDetail 正文
- ErrorResponseException：ErrorResponse 介面的一個實現，可以作為一個方便的基類。擴展自定義的錯誤處理類。
- ResponseEntityExceptionHandler：它處理所有 Spring MVC 異常，與@ControllerAdvice 一起使用。
  以上類型作為異常處理器方法的返回值，框架將返回值格式化為 RFC 7807 的字段。ProblemDetail 類方法位於 `org.springframework.http.ProblemDetail`。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0ac47ff8-ec8c-4845-9086-45e241dceec1/Untitled.png)

ErrorResponse是一個介面，而ErrorResponseException則是它的實現類，用來處理應答錯誤的status、header和ProblemDetail。在SpringMVC中，異常處理方法（帶有@ExceptionHandler）會返回ProblemDetail，而ErrorResponse則會被處理成符合RFC 7807規範的格式。

### ProblemDetail 自定義異常處理器

範例：

> 需求：我們示例查詢某個 isbn 的圖書。在 application.yml 中配置圖書的初始數據。用戶訪問一個 api 地址，查詢某個 isbn 的圖書， 查詢不到拋出自定義異常 BootNotFoundException。自定義異常處理器捕獲異常。ProblemDetail 作為應答結果。支持 RFC
>
- application.yml 配置圖書基礎數據

    ```yaml
    # 指定初始Book數據(代替資料庫)
    product:
      books:
        - isbn: B001
          name: java
          author: lisa
        - isbn: B002
          name: tomcat
          author: susan
        - isbn: B003
          name: jvm
          author: zico
    ```

- 建立 Bean

    ```java
    public record Book(String isbn, String name, String author) {}
    ```

- 建立存儲多本圖書的 Container 類

    ```java
    @Setter
    @Getter
    @ConfigurationProperties(prefix = "product")
    public class BookContainer {
        private List<Book> books;
    }
    ```

- 啟動類上方加上 `@EnableConfigurationProperties` 註解

    ```java
    @EnableConfigurationProperties({BookContainer.class})
    @SpringBootApplication
    public class Lesson17ProblemDetailApplication {
    
    	public static void main(String[] args) {
    		SpringApplication.run(Lesson17ProblemDetailApplication.class, args);
    	}
    
    }
    ```

- 建立自定義異常類

    ```java
    public class BookNotFoundException extends RuntimeException {
        public BookNotFoundException() {
            super();
        }
    
        public BookNotFoundException(String message) {
            super(message);
        }
    }
    ```

- 建立 Controller

    ```java
    @RestController
    public class BookController {
        @Resource
        private BookContainer bookContainer;
    
        @GetMapping("/book")
        public Book getBook(String isbn) {
            Optional<Book> book = bookContainer.getBooks().stream()
                    .filter(e1 -> e1.isbn().equals(isbn))
                    .findFirst();
            if (book.isEmpty()) {
                throw new BookNotFoundException("isbn: " + isbn + " -> 沒有此圖書");
            }
            return book.get();
        }
    
    }
    ```

- 建立異常處理器

    ```java
    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = {BookNotFoundException.class})
        public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
            // type：異常類型，是一個uri，uri找到解決問題的途徑
            problemDetail.setType(URI.create("/api/probs/not-found"));
            problemDetail.setTitle("圖書異常");
            return problemDetail;
        }
    }
    ```


- 異常響應結果

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0eed05db-92ad-41a6-b6b5-a95b1db6e702/Untitled.png)


### 擴展 ProblemDetail

修改異常處理方法，增加 ProblemDetail 自定義字段，自定義字段以 Map<String,Object>存儲，調用setProperty(name,value)將自定義字段添加到 ProblemDetail

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        // type：異常類型，是一個uri，uri找到解決問題的途徑
        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("圖書異常");

        // 增加自定義字段
        // 時間戳
        problemDetail.setProperty("timestamp", Instant.now());
        // 客服信箱
        problemDetail.setProperty("客服信箱", "test@gmail.com");
        return problemDetail;
    }

}
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/888e8a84-997d-4c5a-b1cb-5ee914b7a2c7/Untitled.png)

### ErrorResponse

在Spring Boot中，可以使用ErrorResponse作為異常處理方法的返回值，並且它也是識別異常類型的一種方式。而ErrorResponseException則是ErrorResponse的基本實現類。

- 增加下面的方法

    ```java
    @RestControllerAdvice
    public class GlobalExceptionHandler {
    
        @ExceptionHandler({BookNotFoundException.class})
        public ErrorResponse handleException(BookNotFoundException e) {
            return new ErrorResponseException(HttpStatus.NOT_FOUND, e);
        }
    
    }
    ```

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4dc7e5e1-466d-4130-8944-021519d014d1/Untitled.png)


### 擴展 ErrorResponseException

自定義異常可以擴展 ErrorResponseException， SpringMVC 將處理異常並以符合 RFC 7807 的格式返回錯誤響應。 ResponseEntityExceptionHandler 能夠處理大部分 SpringMVC 的異常

其方法 handleException()提供了對 ErrorResponseException 異常處理：

```java
@ExceptionHandler({
...
ErrorResponseException.class,
...
})
@Nullable
public final ResponseEntity<Object> handleException(Exception ex, WebRequest
request) {...}
```

由此可以創建自定義異常類，繼承 ErrorResponseException，剩下的交給 SpringMVC 內部自己處理就好。省去了自己的異常處理器，@ExceptionHandler。

範例：

- 創建新的異常類繼承 ErrorResponseException

    ```java
    // 自定義異常類，讓SpringMVC的異常處理器使用
    public class IsbnNotFoundException extends ErrorResponseException {
    
        public IsbnNotFoundException(HttpStatus status, String detail) {
            super(status, createProblemDetail(status, detail), null);
        }
    
        private static ProblemDetail createProblemDetail(HttpStatus status, String detail) {
            // 封裝 RFC7807 字段
            ProblemDetail problemDetail = ProblemDetail.forStatus(status);
            problemDetail.setType(URI.create("/api/probs/not-found"));
            problemDetail.setTitle("圖書異常");
            problemDetail.setDetail(detail);
            // 自定義字段
            problemDetail.setProperty("嚴重程度", "低");
            problemDetail.setProperty("客戶信箱", "test@gmail.com");
            return problemDetail;
        }
    
    }
    ```

- 抛出 IsbnNotFoundException

    ```java
    @RestController
    public class BookController {
        @Resource
        private BookContainer bookContainer;
    
        @GetMapping("/book")
        public Book getBook(String isbn) {
            Optional<Book> book = bookContainer.getBooks().stream()
                    .filter(e1 -> e1.isbn().equals(isbn))
                    .findFirst();
            if (book.isEmpty()) {
                throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "isbn: " + isbn + " -> 沒有此圖書");
            }
            return book.get();
        }
    
    }
    ```

- 啟動 RFC 7807 支持，修改 application.yml，增加配置

    ```yaml
    # 開啟支持 RFC7807
    spring:
      mvc:
        problemdetails:
          enabled: true
    ```

  ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9be1f52f-1bd3-4b5e-890d-216ee0c495f9/Untitled.png)

# 遠程訪問@HttpExchange[SpringBoot 3]
Spring Boot 提供多種遠程訪問技術，其中基於 HTTP 協議的遠程訪問是最廣泛使用的。Spring Boot 3 引入了新的 HTTP 訪問能力，通過介面簡化 HTTP 遠程訪問，類似 Feign 功能。Spring 包裝了底層 HTTP 客戶端的訪問細節。

我們可以定義接口提供 HTTP 服務，生成的代理對象實現此介面，並實現 HTTP 的遠程訪問。需要理解：

- `@HttpExchange`
- WebClient

我們想要調用其他系統提供的 HTTP 服務，通常可以使用 Spring 提供的 RestTemplate 來訪問，
RestTemplate 是 Spring 3 中引入的同步阻塞式 HTTP 客戶端，因此存在一定性能瓶頸。

**WebClient 特性：**

WebClient 是 Spring 5 中引入的非阻塞式 HTTP 客戶端，

- 支持響應式編程，基於 Reactor
- 相較於 RestTemplate，WebClient 非阻塞且異步請求
- 支持高並發且硬件資源占用少。
- 支持 Java 8 lambdas 函數式編程。

**什麼是異步非阻塞**

在理解 WebClient 時，需要了解異步和同步、阻塞和非阻塞之間的區別。

異步和同步針對調度者，而阻塞和非阻塞針對被調度者。如果調用者發送請求後等待對方回應之後才去做其他事情，就是同步；如果發送請求之後不等待對方回應就去做其他事情，就是異步。

而被調度者收到請求後，做完請求任務之後才給出反饋就是阻塞；收到請求之後馬上給出反饋然後去做事情，就是非阻塞。

## 聲明式HTTP遠程服務

[JSONPlaceholder](https://jsonplaceholder.typicode.com/)：這個網站是提供開發人員測試和模擬 REST API 的平台，它提供了一些假的 JSON 資料，可以讓開發人員使用 HTTP 請求進行測試。這個網站的資料是假的，僅供測試使用。

範例：

- 聲明 Todo 數據類

    ```java
    @Data
    public class Todo {
        private Integer userId;
        private Integer id;
        private String title;
        private Boolean completed;
    }
    ```

- 聲明服務介面

    ```java
    public interface TodoService {
        // 一個方法就是一個遠程服務(遠程調用)
        @GetExchange("/todos/{id}")
        Todo getTodoById(@PathVariable("id") Integer id);
    
        @PostExchange(value = "/todos/", accept = MediaType.APPLICATION_JSON_VALUE)
        Todo createTodo(@RequestBody Todo todo);
    
        // 修改資源
        @PutExchange("/todos/{id}")
        ResponseEntity<Todo> modifyTodo(@PathVariable Integer id, @RequestBody Todo todo);
    
        // 刪除
        @DeleteExchange("/todos/{sid}")
        void removeTodo(@PathVariable("sid") Integer id);
    }
    ```

- 創建 HTTP 服務代理物件

    ```java
    @Configuration(proxyBeanMethods = false)
    public class HttpConfiguration {
    
        // 創建服務介面的代理物件，基於 WebClient
        @Bean
        public TodoService requestService() {
            WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
            // 創建代理工廠
            HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
            // 創建某個介面的代理服務
            return proxyFactory.createClient(TodoService.class);
        }
    
    }
    ```

- 測試呼叫

    ```java
    @SpringBootTest
    class Lesson18HttpServiceApplicationTests {
    
        // 注入代理物件
        @Resource
        private TodoService todoService;
    
        // 測試訪問 todos/1
        @Test
        void testQuery() {
            Todo todo = todoService.getTodoById(1);
            System.out.println("todo = " + todo);
    
            //class jdk.proxy2.$Proxy52
            System.out.println("todoService = " + todoService.getClass());
            Integer id = todo.getId();
            Integer userId = todo.getUserId();
        }
    
      // 創建資源
    	@Test
    	void testCreateTodo(){
    		Todo todo = new Todo();
    		todo.setId(1001);
    		todo.setUserId(5005);
    		todo.setTitle("事項1");
    		todo.setCompleted(true);
    
    		Todo resultTodo = todoService.createTodo(todo);
    		System.out.println("resultTodo = " + resultTodo);
    	}
    
    	@Test
    	void testModify() {
    		Todo todo = new Todo();
    		todo.setId(1002);
    		todo.setUserId(5002);
    		todo.setTitle("事項2");
    		todo.setCompleted(true);
    
    		ResponseEntity<Todo> entity = todoService.modifyTodo(2, todo);
    
    		HttpHeaders headers = entity.getHeaders();
    		System.out.println("headers = " + headers);
    
    		Todo body = entity.getBody();
    		System.out.println("body = " + body);
    
    		HttpStatusCode statusCode = entity.getStatusCode();
    		System.out.println("statusCode = " + statusCode);
    
    	}
    
    	@Test
    	void testDelete() {
    		todoService.removeTodo(10);
    	}
    
    }
    ```


## HTTP服務介面的方法定義

`@HttpExchange` 註解用於聲明介面作為 HTTP 遠程服務，可以在方法和類別級別使用。通過註解屬性以及方法的參數設置 HTTP 請求的細節。
快捷註解簡化不同的請求方式：

- `@GetExchange`
- `@PostExchange`
- `@PutExchange`
- `@PatchExchange`
- `@DeleteExchange`

這些註解可以方便地設置 HTTP 請求的細節，例如 URL、請求體、請求標頭等。使用這些註解可以更加方便地定義和實現 HTTP 遠程服務。

@GetExchange 就是@HttpExchange 表示的 GET 請求方式

```java
@HttpExchange(method = "GET")
public @interface GetExchange {
	@AliasFor(annotation = HttpExchange.class)
	String value() default "";
	@AliasFor(annotation = HttpExchange.class)
	String url() default "";
	@AliasFor(annotation = HttpExchange.class)
	String[] accept() default {};
}
```

作為 HTTP 服務介面中的方法允許使用的參數列表

| 參數 | 說明 |
| --- | --- |
| URI | URI 設置請求的 url，覆蓋註解的 url 屬性 |
| HttpMethod | 請求方式，覆蓋註解的 method 屬性 |
| @RequestHeader | 添加到請求中 header。參數類型可以為 Map<String,?>、MultiValueMap<String,?>、單個值或者 Collection<?> |
| @PathVariable | url 中的佔位符，參數可為單個值或 Map<String,?> |
| @RequestBody | 請求體，參數是對象 |
| @RequestParam | 請求參數，單個值或 Map<String,?>、MultiValueMap<String,?>、Collection<?> |
| @RequestPart | 發送文件時使用 |
| @CookieValue  | 向請求中添加 cookie |

介面中方法返回值

| 返回值類型  | 說明 |
| --- | --- |
| void | 執行請求，無需解析應答 |
| HttpHeaders | 存儲 response 應答的 header 信息 |
| 物件 | 解析應答結果，轉為聲明的類型物件 |
| ResponseEntity<Void>、ResponseEntity<T> | 解析應答內容，得到 ResponseEntity，從 ResponseEntity 可以獲取 http 應答碼、header、body 內容 |

反應式的相關的返回值包含 Mono<Void>,Mono<HttpHeaders>,Mono<T>,Flux<T>
Mono<ResponseEntity<Void>>,Mono<ResponseEntity<T>>,Mono<ResponseEntity<Flux<T>>

## 組合使用註解

@HttpExchange ， @GetExchange 等可以組合使用。
範例：

- 創建 Albums 數據類

    ```java
    @Data
    public class Album {
        private Integer userId;
        private Integer id;
        private String title;
    }
    ```

- 創建 AlbumsService 介面

    ```java
    @HttpExchange(url = "https://jsonplaceholder.typicode.com/")
    public interface AlbumService {
        // 查詢專輯
        @HttpExchange(method = "GET", url = "/albums/{id}")
        Album getById(@PathVariable Integer id);
    }
    ```

- 聲明代理

    ```java
    @Configuration(proxyBeanMethods = false)
    public class HttpConfiguration {
    		// 創建代理
        @Bean
        public AlbumService albumService() {
            WebClient webClient = WebClient.create();
            HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                    .builder(WebClientAdapter.forClient(webClient)).build();
    
            return proxyFactory.createClient(AlbumService.class);
        }
    }
    ```

- 單元測試

    ```java
    @SpringBootTest
    public class TestAlbumsService {
        @Resource
        private AlbumService albumService;
        @Test
        void testQuery() {
            Album album = albumService.getById(5);
            System.out.println("album = " + album);
        }
    }
    ```


## Java Record

測試 Java Record 作為返回類型，由框架的 HTTP 代理轉換應該內容為 Record 物件

範例：

- 創建 Record

    ```java
    public record AlbumRecord(Integer userId, Integer id, String title) {}
    ```

- AlbumService 介面增加新的遠程訪問方法，方法返回類型為 Record

    ```java
    @HttpExchange(url = "https://jsonplaceholder.typicode.com/")
    public interface AlbumService {
        // 使用 Java Record
        @HttpExchange(method = "GET", url = "/albums/{id}", contentType = MediaType.APPLICATION_JSON_VALUE)
        AlbumRecord getByIdReturnRecord(@PathVariable Integer id);
    }
    ```

- 單元測試

    ```java
    @Test
    void testRecord() {
    	 AlbumRecord record = albumService.getByIdReturnRecord(2);
       System.out.println("record = " + record);
    }
    ```


## 訂製HTTP請求服務

設置 HTTP 遠程的超時時間， 異常處理
在創建介面代理物件前，先設置 WebClient 的有關配置

範例：

- 設置超時，異常處理

# 視圖技術 Thymeleaf
Thymeleaf是一個常用於Web環境中的表現層模板引擎，能處理HTML、XML、JS等文件。它可以將JSP 作為 Java Web 應用的表現層，有能力展示與處理數據。Thymeleaf 讓表現層的界面節點與程序邏輯被共享，這樣的設計可以讓界面設計人員、業務人員與技術人員都參與到項目開發中。

同一個模板文件既可以使用瀏覽器直接打開，也可以放到伺服器中用來顯示數據，並且樣式之間基本上不會存在差異。因此，界面設計人員與程序設計人員可以使用同一個模板文件，來查看靜態與動態數據的效果。

Thymeleaf作為視圖展示模型數據，用於和用戶交互操作，是一種易於學習和掌握的技術。尤其適合做管理系統。通過幾個示例，可以掌握Thymeleaf基礎應用。

## 表達式

表達式用於在頁面展示數據的，有多種表達式語法，最常用的是變量表達式、鏈接表達式。

| 表達式 | 作用 | 例子 |
| --- | --- | --- |
| $ {...} | 變量表達式，可用於獲取後台傳過來的值 | <p th:text="${userName}">台灣</p> |
| @ {...} | 鏈接網址表達式 |  th:href="@{/css/home.css” |

範例：

- 創建Controller

    ```java
    @Controller
    public class ThymeleafController {
    
        // 表達式，方法的返回值表示view，一個xxx.html夜面
        @GetMapping("/expression")
        public String expression(Model model) {
            // model中的數據，最後是放到request作用域的。
            model.addAttribute("name", "財政部資訊中心");
            model.addAttribute("address", "台北市信義區");
            return "exp"; // 是一個view exp.html
        }
    }
    ```

    - `exp`：這是一個名稱，表示視圖的名稱。
    - `templates`：這是一個目錄，默認存放視圖文件的目錄。
    - 視圖文件：在 `templates` 目錄下存放的視圖文件，一定是經過服務器處理過後才能呈現的。
    - 當 `Controller` 方法返回 `exp` 後，因為在項目中存在 Thymeleaf 依賴，這個視圖就會交給 Thymeleaf 模板引擎處理。
    - Thymeleaf 會到 `templates` 目錄底下找 `exp` 的文件，找到之後會處理這個文件。
    - 把這個文件凡是出現 `${}` 的地方，都會替換成對應的數據，將替換後的結果和處理後的 HTML 文件的內容，輸出到瀏覽器。
- 在 `templates` 目錄底下創建 html 文件

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>exp</title>
        </head>
        <body>
          <h3>表達式</h3>
          <div th:text="${name}"></div>
          <div th:text="${address}"></div>
    
          <h3>鏈接表達式</h3>A
          <p><a th:href="@{https://www.google.com.tw/}">連接到google</a></p>
          <p><a th:href="@{/link}">連接到link地址</a></p>
          <p><a th:href="@{/link(id=111,name=lisa)}">連接表達式，傳遞參數(參數名=值，參數名=值...)</a></p>
        </body>
    </html>
    ```


## if - for

Thymeaf 同樣支持 if - for 語句的使用。

| 表達式  | 作用 | 例子 |
| --- | --- | --- |
| th:if=“boolean 表達式” | th:if 當條件滿足時，顯示代碼片段。條件常用 boolean 表示，true 滿足，反之不滿足。 | <div th:if=“10>2”>
     顯示此內容
</div> |
| <tr th:each=” 成 員 遍
歷:${表達式}”>
<td th:text=”${ 成
員}”> 列 </td>
</tr> | th:each 處 理 循 環 ， 類 似 jstl 中 的 <c:foreach> | <table>
  <tr th:each=“item:${list}”>
    <td th:text=“${item}”>
  </tr>
</table> |

範例：

- 創建 Bean

    ```java
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserVO {
        private Integer id;
        private String name;
        private Integer age;
    }
    ```

- 創建 Controller 方法

    ```java
    @Controller
    public class ThymeleafController {
        // if - for
        @GetMapping("/if-for")
        public String ifFor(Model model) {
            model.addAttribute("login", true);
            UserVO user = new UserVO();
            user.setId(10);
            user.setName("Lisa");
            user.setAge(20);
            model.addAttribute("user", user);
    
            // 創建List集合
            List<UserVO> users = List.of(new UserVO(11, "Lisa", 21), new UserVO(12, "Susan", 22));
            model.addAttribute("users",users);
    
            return "base";
        }
    }
    ```

- 在 `templates` 目錄底下創建 html 文件

    ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>if-for</title>
        </head>
        <body>
          <h3>if-for</h3>
          <div th:if="10 > 20">10 > 2</div>
          <div th:if="${login}">用戶已經登錄</div>
          <div th:if="${user.age > 18}">用戶成年了</div>
    
          <hr/>
          <h3>th:each循環</h3>
          <table border="1">
            <tr>
              <td>id</td>
              <td>name</td>
              <td>age</td>
            </tr>
            <tr th:each="user:${users}">
              <td th:text="${user.id}"></td>
              <td th:text="${user.name}"></td>
              <td th:text="${user.age}"></td>
            </tr>
          </table>
        </body>
    </html>
    ```


- application.properties 中默認配置

    ```
    spring.thymeleaf.prefix=classpath:/templates/
    spring.thymeleaf.suffix=.html
    ```


⭐ 更多詳細內容可參考 [官方文檔](https://www.thymeleaf.org/documentation.html) 中的 [Tutorial: Using Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)


# 了解 AOT 和 GraalVM
## **提供性能的技術**

### **AOT和JIT編譯**

AOT和JIT都是提升Java程序性能的技術。

### AOT

AOT是Ahead-of-Time Compilation的縮寫，即預編譯（提前編譯）。在 Java 9 中，AOT被作為實驗性功能添加，并在JEP-295中進行了描述。

在AOT中，Java類被編譯為本機代碼，並在啟動虛擬機之前完成，以改進小型和大型Java應用程序的啟動時間。AOT提供了一種減少JVM啟動時間的方法。

### JIT

JIT是Just-in-Time Compilation的縮寫，即即時編譯。JIT是現在JVM提高執行速度的技術。

當JVM發現某個方法或代碼塊運行特別頻繁時，就會將其編譯為本機機器碼。這稱為實時（JIT）編譯。編譯後的機器碼被緩存以備下次使用，以提高程序的執行速度。

JVM根據**執行期間**收集的分析信息決定JIT編譯哪些代碼。JIT編譯器速度很快，但是Java程序非常大，以至於JIT需要很長時間才能完全預熱。不經常使用的Java方法可能根本不會被編譯。

### **AOT和JIT的區別**

- AOT是靜態編譯，JIT是動態編譯。
- AOT在程序啟動前進行編譯，JIT在程序執行時進行編譯。
- AOT可以減少JVM啟動時間，而JIT可以提高程序的執行速度。

這些技術都是Java中提高程序性能的重要手段。選擇使用哪種技術，需要根據具體情況進行選擇，以達到最佳的性能效果。

## **Native Image**

### native image：原生鏡像（本機鏡像）

native image is a technology to ahead-of-time compile Java code to a standalone executable, called a native image

**Native image** 是一種預先將Java代碼編譯為獨立可執行檔的技術，稱為本機映像（原生鏡像）。這個映像是用於執行的文件。通過鏡像構建技術（工具）可以生成鏡像文件（native image）。

**Native image** 支持基於JVM的語言，例如Java、Scala、Clojure和Kotlin等。它的文件內容包括應用程序類、來自其依賴項的類、運行時庫類以及來自JDK的靜態鏈接本機代碼（二進制文件可以直接運行，不需要額外安裝JDK）。**Native image**運行在GraalVM上，具有更快的啟動時間和更低的運行時內存開銷。

在AOT模式下，編譯器在構建項目期間執行所有編譯工作。這裡的主要想法是將所有的"繁重工作" - 昂貴的計算 - 轉移到構建時間。也就是說，把項目都要執行的所有東西都準備好，具體執行的類、文件等。最後執行這個準備好的文件，此時應用能夠快速啟動。這樣可以減少內存和CPU開銷（無需運行時的JIT的編譯），因為所有東西都是預先計算和預先編譯好的。

## **Native Image Builder**

**Native Image Builder**（鏡像構建器）是一個實用程序，用於處理應用程序的所有類及其依賴項，包括來自JDK的類。它靜態地分析這些數據，以確定在應用程序執行期間可以訪問哪些類和方法。然後，它預先將可到達的代碼和數據編譯為特定操作系統和體系結構的本機可執行文件。

## GraalVM

GraalVM 是一個高性能的 JDK 發行版，旨在加速用 Java 和其他 JVM 語言編寫的應用程序，同時支持 JavaScript、Ruby、Python 和許多其他流行語言。GraalVM 的多語言功能可以在單個應用程序中混合多種編程語言，同時消除外語調用成本。GraalVM 是一個支持多語言的虛擬機。

GraalVM 是 OpenJDK 的替代方案，並包含了一個名為 "native image" 的工具，支持預先編譯（Ahead-Of-Time, AOT）。使用 native image 工具，GraalVM 執行本地映像文件的啟動速度更快，使用的 CPU 和內存更少，磁盤大小也更小。這使得 Java 在雲端中更具競爭力。

目前，GraalVM 的 AOT 的重點是允許使用 GraalVM 將 Spring 應用程序部署為本機映像。在 Spring Boot 3 中，GraalVM 方案提供了 Native Image 支持。

GraalVM 的 "native image" 工具將 Java 字節碼作為輸入，輸出一個本地可執行文件。該工具對字節碼進行靜態分析，在分析過程中，該工具尋找你的應用程序實際使用的所有代碼，並消除一切不必要的東西。"native image" 是封閉式的靜態分析和編譯，不支持 class 的動態加載，程序運行所需要的所有依賴項均在靜態分析階段完成。

因此，GraalVM 是一個高效、多語言的虛擬機，其支持的 AOT 編譯能夠讓 Java 程序在雲端中更具競爭力，而 "native image" 工具能夠將 Java 程序打包為本地可執行文件，具有更快的啟動速度和更小的空間佔用。

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/73759c79-9cd3-4f70-84b5-7194c7a0fbdf/Untitled.png)