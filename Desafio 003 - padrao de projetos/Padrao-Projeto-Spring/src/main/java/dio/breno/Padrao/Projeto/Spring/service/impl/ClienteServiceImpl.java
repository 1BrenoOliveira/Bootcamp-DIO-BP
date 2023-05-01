package dio.breno.Padrao.Projeto.Spring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dio.breno.Padrao.Projeto.Spring.model.Cliente;
import dio.breno.Padrao.Projeto.Spring.model.ClienteRepository;
import dio.breno.Padrao.Projeto.Spring.model.Endereco;
import dio.breno.Padrao.Projeto.Spring.model.EnderecoRepository;
import dio.breno.Padrao.Projeto.Spring.service.ClienteService;
import dio.breno.Padrao.Projeto.Spring.service.ViaCepService;

public class ClienteServiceImpl implements ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional <Cliente>  cliente= clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		SalvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()) {
			SalvarClienteComCep(cliente);
		}
		
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}

	
	private void SalvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}
}
