Desafio 002

projeto de ...

## OBS: Sem utilizar a Class WebSecurityConfigurerAdapter
Usei como referencia para substituir a implementação sem a classe WebSecurityConfigurerAdapter na documentação do Spring (https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter).

### COMMIT 1
estrutura basica do spring security onde o login padrao, o username é "User" e o password é gerado aleatoriamente a cada execução e exibido no console. É a estrutura mais simples do Spring boot Security.

### COMMIT 2 - Autenticação simples
essa é a forma mais simples de autenticação em um projeto spring boot. É possivel salvar a senha, password e role de acesso no arquivo application.properties para que seja uma padrao em todos as execuções. 
São essas:

 - spring.security.user.name=Breno               //nome do seu usuario
 - spring.security.user.password=dio123          //senha de acesso
 - spring.security.user.roles=USERS              // nivel de permissão
 
Salvando essas configurações no application.properties, voce ja conseguirá executar e logar-se com o acesso que voce definiu...

#### Em memoria
É necessario criar uma classe de configuração, usando as Anotações @Configuration e @EnableWebSecurity e criaremos o metodo UserDetailsService.

OBS: 
1º) Devido a classe WebConfigurerAdapter ser depreciada e nao permitindo importa-la mais, eu utilizei uma implementação um pouco diferente, diferente do conteudo visto na aula do Bootcamp da Digital Innovation One.
2º) Caso ocorra erro de execução insira as seguintes configurações no application.properties:
 - spring.main.allow-bean-definition-overriding=true
 - spring.main.allow-circular-references= true

 Implementando essa classe, conseguiremos criar mais de um usuario na memoria.

Se estamos buscando o controle de permissões, vamos adicionar acima da classe de condiguração, a anotação @EnableGlobalMethodSecurity(prePostEnabled=true) e adicionar nos methodos que deseja colocar o controle de acesso a anotação @PreAuthorize("hasRole('ADMIN')") - sendo admin a role de acesso.

 
 #### COMMIT 3 - Configure Adapter / no caso utilizamos um Bean para nao ter q usar a classe com o Adapter
- removemos o controle de autenticação das classes controller, as formas expilicitas, reunindo tudo dentro da classe de configuração.

Criar o metodo filterChain que ira comportar os controle de acessos na aplicação... 


#### COMMIT 4  - persistindo dandos em um banco MySql

-Removemos o acesso dos usuario que era feitos em memoria interna, na classe de configuração, e adicionando metodos para persistir e encriptar as senhas.
-Criamos a entidade USER, com as configurações para criar a classe no banco
-Criamos A interface Repository, para permitir a execução das query's
-Criamos a classe SecurityDatabaseService que fara a leitura e validação dos logins
-por fim, criamos a classe StartApplication forçando a execução com inserções de usuarios no banco de dados...

OBS: 
1º) Vale ressaltar que as configurações de acesso do banco de dados ja haviam sido configuradas no Application.properties:
        spring.datasource.url=jdbc:mysql://localhost:3306/UserManagement?allowPublicKeyRetrieval=true&useSSL=false
        spring.datasource.username=root
        spring.datasource.password =123456


        spring.jpa.show.sql=true
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.open-in-view=false
2º) É necessario inserir as dependencias do Spring data e driver MySQL, ja inseridas anteriormente...

#### COMMIT 5 - Focando no JWT

Nesse commit, foi inserido umm novo projeto que começamos a implementar, para usar como foco a utilização de tokens para validações, acessos, com o uso do JWT

Criamos um arquivo do zero, adicionamos as configuração do banco de dados no Application.properties e começamos a implementar.

Vamos criar uma estrutura basica da aplicação novamente, com mvc do User, depois implementaremos a estrutura do JWT:
1º) O token em si é um objeto java, entao criaremos a classe do objeto(JWTObject)
2º) Criaremos a classe que recebera as propriedades e credencias do token via application.properties(JWTCreator)
3º) Criaremos a classe que ira gerar os tokens(JWTCreator)
4º)Criaremos a classe que filtrará, fará a logica da validação dos tokens
5º) Adicionar configurações no Application.properties:
       - security.config.prefix=Bearer
       - security.config.key=SECRET_KEY
       - security.config.expiration=3600000 //tempo de expiração
6º) E como configuramos o Spring Security, precisamos configurar o projeto para reconhecer e utilizar as classes JWT para validação. Criaremos a classe WebSecurityConfig.
OBS: Nessa parte, teremos que alterar um pouco do codigo visto no curso, devido a classe WebSecurityConfigurerAdapter nao está mais em utilização, nao sendo possivel nem importa-la mais...