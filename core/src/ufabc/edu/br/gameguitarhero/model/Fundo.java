package ufabc.edu.br.gameguitarhero.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

public class Fundo extends AbstractModel{
	private int 				state;
	private GameObject 			gameObject;
	private TextureAttribute 	tex;

	public Fundo(String id) {
		super(id);
		
		//Cria o modelo, este modelo defini o ponto inicial de renderização dos modelos do jogo.
		ModelBuilder builder = new ModelBuilder();
		tex = new TextureAttribute(TextureAttribute.createDiffuse(new Texture(Gdx.files.internal("models/estrelas.png"))));
		gameObject = new GameObject(builder.createBox(10.0f, 10.0f, 0.0001f, new Material(tex),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates));
		gameObject.transform.translate(0, 0, -2.0f);
	}

	@Override
	public void update(float delta) {
		gameObject.update(delta);
	}
	
	public void translate(Vector3 velocidade) {
		gameObject.transform.translate(velocidade);
	}

	@Override
	public GameObject getCurrent() {
		return gameObject;
	}

	@Override
	public int getState() {
		return state;
	}

	@Override
	public void setGamePosition() {
		
	}

	@Override
	public void setState(int state) {
		
	}

	@Override
	public String[] getDescription() {
		return null;
	}
	
}
