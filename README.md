# MVC1
This project is using the Spring Source Toolsuite (STS) available at https://spring.io/tools/sts/all
STS is eclipsed base and has many plugins out of the box.  This include the "Pivotal tc Server", which is Tomcat,
so don't get freaked out.

I am still editing this project, so it is a work in progress for my own benefit.  My next step is to add the angular 
coded for the front end stuff.  My knowledge of Angular1 is based on the book, Angularjs for beginners, available
at https://www.amazon.com/Angularjs-beginners-Learn-angularjs-step/dp/1520133545/ref=sr_1_2?ie=UTF8&qid=1487683936&sr=8-2&keywords=angular+for+beginners

As a developer, I have over 30 years of experience and have developing software since 1985.  You can see my resume on github.

After I finish with this I should be a pro at Angular. :-)

After you build this project in STS and add it the Pivotal tc Server, you should be able to run it with http://localhost:8080/myapp
which give you the hello world web page.

So, as I stated in the description, this applcation is a java spring/hibernate application and it connects to MySQL.  You can
get MySQL at https://dev.mysql.com/downloads/mysql/

You are going to have to set up schema for "mydb" in order for the application to startup.

You need to add the mysql-connector-java-5.1.39-bin.jar to your User Entries in the "Edit lauch configuration properties" if
if it is not already there.  This can be done by opening the "Pivotal tc Server" in your "Servers" tab.

Under Servers in the Package Explorer, you need to navigate the the context.xml file and add the following:
<ResourceLink global="jdbc/MyDb" name="jdbc/MyDb" type="org.apache.tomcat.jdbc.pool.DataSource"/>

In the server.xml file, you will need to add the following:
		<Resource auth="Container" driverClassName="com.mysql.jdbc.Driver" factory="org.apache.tomcat.jdbc.pool.DataSourceFactory" initialSize="20" maxAge="7200000" maxIdle="20" maxTotal="75" maxWaitMillis="15000" name="jdbc/MyDb" password="mydb" testOnBorrow="true" type="org.apache.tomcat.jdbc.pool.DataSource" url="jdbc:mysql://localhost:3306/mydb" username="mydb" validationQuery="select 1"/> 

in the <GlobalNamingResources> just before the last entry.

This sets up the jndi connection in Tomcat for the database.

Once you have MySQL installed and the schema set up, the application should start with no errors.  If you don't want the database to
be created each time, then modify the application.properties file and set the "hibernate.createorupdate = update".

You can use the MySQL Workbench to create the schema/user for mydb.  I have set the username to be mydb and the password is the same.
