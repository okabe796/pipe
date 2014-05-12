package matchers.component;


import uk.ac.imperial.pipe.models.component.transition.Transition;

public class HasTimed implements Has<Transition> {
    boolean timed;
    public HasTimed(boolean timed) {
        this.timed = timed;

    }

    @Override
    public boolean matches(Transition component) {
        return component.isTimed() == timed;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
