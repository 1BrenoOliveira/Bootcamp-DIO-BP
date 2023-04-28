Desafio 002

projeto de ...

## OBS: Sem utilizar a Class WebSecurityConfigurerAdapter

### COMMIT 1
estrutura basica do spring security onde o login padrao, o username é "User" e o password é gerado aleatoriamente a cada execução e exibido no console. É a estrutura mais simples do Spring boot Security.

### COMMIt 2 - Autenticação simples
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

 