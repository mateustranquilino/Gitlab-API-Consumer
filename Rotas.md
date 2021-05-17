# Rotas API Gitlab

> base = https://gitlab.com/api/v4
___
### Repositorios (Projetos)
- [x] Listar os repositorios de um usuario
    > GET /user/{user_id}/projects
- [ ] Acessar um repositorio especifico
    > GET /projects/{repo_id}
- [ ] Listar commits no repositorio
  > GET /projects/{repo_id}/repository/commits
  
  O atributo ``ref_name`` pode ser adicionado para indicar a branch que queremos analisar.
  Por padrão será a branch default (master)
  
- [ ] Comparar branchs ou commits em um repositorio
  > GET /projects/:id/repository/compare?from={branch_ou_commit_id}&to={branch_ou_commit_id}
- [ ] Listar arquivos e diretorios de um repositorio
    >  GET /projects/{repo_id}/repository/tree
    
    Por default retorna os 20 primeiros arquivos. O parâmetro ``per_page`` 
    pode ser usado para indicar a quantidade de arquivos diferente de 20.
- [ ] Listar contribuidores no repositorio
  > GET /projects/{repo_id}/repository/contributors
  
___
### Usuario
- [ ] Buscar usuario pelo username
    > GET /users?username={username}
    
    Retorna uma lista contendo o usuário para qual o seu nome de usuário combine exatamente com a string `username`, 
    ou uma lista vazia caso não exista.
  
    Busca é case insensitive.


- [ ] Buscar usuarios por uma string  
  > GET /users?search={string}
  
  Retorna uma lista contendo os 20 primeiros usuarios que contenha `string` em seu nome ou username. 
  É preciso estar autenticado para acessar essa rota.
  
  Busca é case insensitive.
  

- [ ] Acessar um usuario pelo id
    > /users/{id}
    
    Essa busca especifica contém mais detalhes do usuario que as demais

___
### Commit
- [ ] Acessar commit especifico
  > GET /projects/{repo_id}/repository/commits/{commit_id}
- [ ] Criar um commit com varias ações e arquivos
  > POST /projects/{repo_id}/repository/commits
  
  No body da requisição é necessario informar para qual branch o commit será feito, a mensagem de commit e uma lista de ações.
  [Mais informações aqui](https://docs.gitlab.com/ee/api/commits.html#create-a-commit-with-multiple-files-and-actions).
  
  Exemplo:
  ``` yaml
  {
    "branch": "master",
    "commit_message": "some commit message",
    "actions": 
    [
      {
      "action": "create",
      "file_path": "/hello.py",
      "content": "print(hello world)"
      }
    ]
  }
  ```
  | Atributo         | Tipo    | Obrigatório | Descrição                                                                                                                                                                                               |
  |:----------------:|:-------:|:-----------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
  | action           | string  | s           | The action to perform, create, delete, move, update, chmod                                                                                                                                              |
  | file_path	     | string  | s           | Full path to the file. Ex. lib/class.rb                                                                                                                                                                 |
  | previous_path    | string  | n           | Original full path to the file being moved. Ex. lib/class1.rb. Only considered for move action.                                                                                                         |
  | content	         | string  | n           | File content, required for all except delete, chmod, and move. Move actions that do not specify content preserve the existing file content, and any other value of content overwrites the file content. |
  | encoding         | string  | n           | text or base64. text is default.                                                                                                                                                                        |
  | last_commit_id   | string  | n           | Last known file commit ID. Only considered in update, move, and delete actions.                                                                                                                         |
  | execute_filemode | boolean | n           | When true/false enables/disables the execute flag on the file. Only considered for chmod action.                                                                                                        |

- [ ] Reverter commit
  > POST /projects/{repo_id}/repository/commits/{commit_id}/revert
  
  No body da requisição deve-se informar qual a branch o commit pertence 
  ``` yaml
  {
    "branch": "master"
  }
  ```
