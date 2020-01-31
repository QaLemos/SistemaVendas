package br.com.gx2.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gx2.dao.ItemCupomFiscalDAO;
import br.com.gx2.entity.ItemCupomFiscal;
import br.com.gx2.exception.DbException;

public class ItemCupomFiscalDAOImp implements ItemCupomFiscalDAO {

	private Connection conn;

	public ItemCupomFiscalDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ItemCupomFiscal itemCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "insert into itens_cupom_fiscal (quantidade, valor_unitario, codigo_produto, codigo_cupom)"
					+ "values" + "(?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, itemCupomFiscal.getQuantidade());
			st.setDouble(2, itemCupomFiscal.getValorUnitario());
			st.setInt(3, itemCupomFiscal.getProduto().getCodigoProduto());
			st.setInt(4, itemCupomFiscal.getCupomFiscal().getCodigoCupom());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void update(ItemCupomFiscal itemCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "update cupons_fiscais set (quantidade, valor_unitario, codigo_produto, codigo_cupom) = ? where codigoCupom = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, itemCupomFiscal.getQuantidade());
			st.setDouble(2, itemCupomFiscal.getValorUnitario());
			st.setInt(3, itemCupomFiscal.getProduto().getCodigoProduto());
			st.setInt(4, itemCupomFiscal.getCupomFiscal().getCodigoCupom());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void deleteById(Integer codigoItemCupomFiscal) {
		PreparedStatement st = null;
		try {
			String sql = "delete from itens_cupom_fiscal where codigo_item_cupom_fical = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoItemCupomFiscal);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<ItemCupomFiscal> findById(Integer codigoItemCupomFiscal) {
		PreparedStatement st = null;
		ResultSet rs = null;
		ItemCupomFiscal itensCupom = null;
		try {

			String sql = "select codigo_item_cupom_fiscal from itens_cupom_fiscal where codigo_item_cupom_fiscal = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, codigoItemCupomFiscal);
			rs = st.executeQuery();
			if (rs.next()) {
				itensCupom = new ItemCupomFiscal();
				itensCupom.setCodigoItemCupomFiscal(rs.getInt("codigo_item_cupom_fiscal"));

			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		return (List<ItemCupomFiscal>) itensCupom;
	}

	@Override
	public List<ItemCupomFiscal> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		ItemCupomFiscal item = null;

		try {

			String sql = "SELECT * FROM Item_cupom_fiscal";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<ItemCupomFiscal> itemCupom = new ArrayList<ItemCupomFiscal>();

			while (rs.next()) {
				item = new ItemCupomFiscal();
				item.setCodigoItemCupomFiscal(rs.getInt("codigo_item_cupom_fiscal"));
				itemCupom.add(item);
			}
			return itemCupom;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
