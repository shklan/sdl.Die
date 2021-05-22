package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements Obj {
    private final static float[] VERTICES = {
            // up left
            -1, 0, -1,
            0, 1, 0,
            -1, 0, 1,
            // up right
            1, 0, -1,
            0, 1, 0,
            1, 0, 1,
            // up back
            -1, 0, -1,
            0, 1, 0,
            1, 0, -1,
            // up front
            -1, 0, 1,
            0, 1, 0,
            1, 0, 1,
            // down left
            -1, 0, -1,
            0, -1, 0,
            -1, 0, 1,
            // down right
            1, 0, -1,
            0, -1, 0,
            1, 0, 1,
            // down back
            -1, 0, -1,
            0, -1, 0,
            1, 0, -1,
            // down front
            -1, 0, 1,
            0, -1, 0,
            1, 0, 1
    };
    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // up left
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
        // up right
        gl.glNormal3f(1,  1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);
        // up back
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);
        // up front
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);
        // down left
        gl.glNormal3f(-1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);
        // down right
        gl.glNormal3f(1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);
        // down back
        gl.glNormal3f(0, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);
        // down front
        gl.glNormal3f(0, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
