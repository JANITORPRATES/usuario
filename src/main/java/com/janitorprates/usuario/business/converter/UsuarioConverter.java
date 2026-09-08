package com.janitorprates.usuario.business.converter;

import com.janitorprates.usuario.business.dto.EnderecoDTO;
import com.janitorprates.usuario.business.dto.TelefoneDTO;
import com.janitorprates.usuario.business.dto.UsuarioDTO;
import com.janitorprates.usuario.infrastructure.entity.Endereco;
import com.janitorprates.usuario.infrastructure.entity.Telefone;
import com.janitorprates.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();

    }

    private List<Telefone> paraListaTelefone(List<TelefoneDTO> telefones) {
        return telefones.stream().map(this::paraTelefone).toList();
    }

    private Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone
                .builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecosDTOs){
//        List<Endereco> enderecos = new ArrayList<>();
//        for(EnderecoDTO enderecoDTO : enderecosDTOs){
//            enderecos.add(paraEndereco(enderecoDTO));
//        }
//        return enderecos;

        return enderecosDTOs
                .stream()
                .map(this ::paraEndereco)
                .toList();
    }

    private Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }
    // CONVERTE PARA DTO'S

    public UsuarioDTO paraUsuarioDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();

    }

    private List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefones) {
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    private TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO
                .builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecos){
        return enderecos
                .stream()
                .map(this ::paraEnderecoDTO)
                .toList();
    }

    private EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .estado(endereco.getEstado())
                .build();
    }

}
