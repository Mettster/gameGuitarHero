package ufabc.edu.br.gameguitarhero.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Disco extends AbstractModel{
	private int state;
	private GameObject gameObject;
	private Attribute attrib[];

	public Disco(String id, Color color) {
		super(id);
		attrib = new Attribute[5];
		attrib[0] = ColorAttribute.createAmbient(Color.BLACK);
		attrib[1] = ColorAttribute.createDiffuse(color);
		attrib[2] = ColorAttribute.createReflection(Color.WHITE);
		attrib[3] = ColorAttribute.createSpecular(color);
		attrib[4] = ColorAttribute.createSpecular(Color.WHITE);
		ModelBuilder builder = new ModelBuilder();
		gameObject = new GameObject(builder.createCylinder(0.08f, 0.005f, 0.05f, 100, new Material(attrib), Usage.Position | Usage.Normal));
	}
	
	

	@Override
	public void update(float delta) {
		gameObject.update(delta);
	}
	
	public void press() {
		gameObject.transform.translate(0.0f, 0.01f, 0.0f);
	}
	
	public void release() {
		gameObject.transform.translate(0.0f, -0.01f, 0.0f);
	}

	@Override
	public GameObject getCurrent() {
		return gameObject;
	}

	@Override
	public int getState() {
		return state;
	}
}